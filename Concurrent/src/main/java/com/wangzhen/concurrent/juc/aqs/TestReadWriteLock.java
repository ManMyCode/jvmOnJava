package com.wangzhen.concurrent.juc.aqs;

import com.wangzhen.concurrent.util.SleepUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {


    public static void main(String[] args) {
        DataContainer dataContainer = new DataContainer();
        new Thread(()->{
            dataContainer.read();
        },"t1").start();
        new Thread(()->{
            dataContainer.read();
            //dataContainer.write(new Object());
        },"t2").start();
    }
}

class DataContainer{
    Logger logger = LoggerFactory.getLogger(DataContainer.class);
    public Object data;
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = rw.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = rw.writeLock();
    public static void main(String[] args) {

    }
    public Object read(){
        logger.debug("获取读锁");
        try{
            readLock.lock();
            logger.debug("开始读取数据");
            SleepUtils.second(1);
            return data;
        }finally {
            logger.debug("释放读锁");
           readLock.unlock();
        }
    }
    public void write(Object obj){
        logger.debug("获取写锁");
        try{
            writeLock.lock();
            logger.debug("开始写数据");
            data=obj;
        }finally {
            logger.debug("释放写锁");
            writeLock.unlock();
        }
    }


}