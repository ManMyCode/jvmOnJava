package com.wangzhen.concurrent.thread.ThreadPool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class testThreadPool {

}


class ThreadPool{
    // 任务队列
    private BlockQueue<Runnable> taskQueue;
    //线程集合
    private HashSet<Worker> workers = new HashSet<>();
    // 核心线程数
    private int coreSize;
    // 超时时间
    private long timeOut;
    //
    private TimeUnit timeUnit;

    public void execute(Runnable task){
        // 当任务没有超过coreSize 时,直接交给worker对象执行
        // 如果任务数超过coreSzie 时，加入任务队里暂存
        synchronized (workers){
            if(workers.size()<coreSize){
                Worker worker=new Worker(task);
                workers.add(worker);
                worker.start();
            }else {
                taskQueue.put(task);
            }
        }

    }

    public ThreadPool(HashSet<Worker> workers, int coreSize, long timeOut, TimeUnit timeUnit) {
        this.workers = workers;
        this.coreSize = coreSize;
        this.timeOut = timeOut;
        this.timeUnit = timeUnit;
        taskQueue= new BlockQueue<>(coreSize);
    }

    class Worker extends Thread{
        private Runnable task;
        public Worker(Runnable task){
            this.task=task;
        }

        public void run(){
            while (task!=null&&((task=taskQueue.take())!=null)){
                try{
                    task.run();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    task=null;
                }
            }

            synchronized (workers){
                workers.remove(this);
            }
        }


    }

}

class BlockQueue<T>{
    // 任务队列
    private Deque<T>  queue= new ArrayDeque<>();
    // 锁
    private ReentrantLock lock=new ReentrantLock();
    // 生产者条件变量
    private Condition fullWaitSet = lock.newCondition();

    // 消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();

    // 容量
    private int queueCapacity;

    public BlockQueue(int capacity) {
        this.queueCapacity = capacity;
    }

    // 带超时的等待
    public T poll(long timeout, TimeUnit timeUnit){
        try{
            lock.lock();
            long nanos = timeUnit.toNanos(timeout);
            while (queue.isEmpty()){
                if(nanos<0){
                    return null;
                }
                try {
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }

    }

    public T take(){
        try{
            lock.lock();
            // 如果队列为空
            while (queue.isEmpty()){
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t= queue.removeFirst();
            fullWaitSet.signal();
            return t;
        } finally {
            lock.unlock();
        }
    }

    public void put(T element){
        try {
            lock.lock();
            while (queue.size()==queueCapacity){
                try {
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.push(element);
            emptyWaitSet.signal();
        }finally {
            lock.unlock();
        }

    }

    public int size(){
        return queue.size();
    }



}
