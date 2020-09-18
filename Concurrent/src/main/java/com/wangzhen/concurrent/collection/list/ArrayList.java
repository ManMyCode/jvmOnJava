package com.wangzhen.concurrent.collection.list;

import java.util.*;

public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess,Cloneable,java.io.Serializable {
    private static final long serialVersionUID = 8683452581122892189L;


    // 默认的初始化容量
    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    transient Object[] elementData;

    private int size;

    public ArrayList(int initialCapacity){
        if(initialCapacity > 0 ){
            this.elementData = new Object[initialCapacity];
        }else if (initialCapacity == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public ArrayList(){
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
    public ArrayList(Collection<? extends E> c) {
//        elementData = c.toArray();
//        if((size = elementData.length)!=0){
//            if(elementData.getClass()!=Object.class)
//                elementData = Arrays.copyOf(elementData,size,Object[].class);
//        }else {
//            // 如果传入的 集合是空的 那么 直接装换一下
//            this.elementData = EMPTY_ELEMENTDATA;
//        }
    }
    public void trimToSize(){

    }

    public void ensureCapacity(int minCapacity) {
        int minExpand = (elementData!=DEFAULTCAPACITY_EMPTY_ELEMENTDATA)? 0 :DEFAULT_CAPACITY;
        if(minCapacity>minCapacity){
            ensureExplicitCapacity(minCapacity);
        }
    }
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    // 最大的数组大小 为 最大值 -8
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity){
        int oldCapacity = elementData.length;
        // 扩展 1.5 倍
        int newCapacity = oldCapacity +(oldCapacity>>1);
        if(newCapacity - minCapacity<0)
            newCapacity = minCapacity;
        if(newCapacity - MAX_ARRAY_SIZE>0){
            newCapacity = MAX_ARRAY_SIZE;
        }
        elementData = Arrays.copyOf(elementData,newCapacity);
    }

    private static int hugeCapacity(int minCapacity){
        if(minCapacity<0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?Integer.MAX_VALUE :MAX_ARRAY_SIZE;
    }




    @Override
    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return size ==0;
    }

    public boolean contains(Object o){
        return indexof(o) >= 0;
    }

    public int indexof(Object o ){
        if(o==null){
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null)
                    return i;
            }
        }else if(o!=null){
            for (int i = 0; i < size; i++) {
                // 这里比较的是 数值 ，所以需要使用 equals
                // 所以需要判断是否为空
                if(o.equals(elementData[i]))
                    return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o){
        if(o==null){
            for (int i=size-1;i>0;i--){
                if(o.equals(elementData[i])){
                    return i;
                }
            }
        }else {
            for (int i=size-1;i>0;i--){
                if(elementData[i]==null){
                    return i;
                }
            }
        }
        return -1;
    }

    public Object clone(){
        try{
            ArrayList<?> v = (ArrayList<?>) super.clone();
            v.elementData = Arrays.copyOf(elementData,size);
            v.modCount = 0;
            return v;
        }catch (Exception e){
            throw new InternalError(e);
        }
    }

    public Object[] toArray(){
        return Arrays.copyOf(elementData,size);
    }

    public <T> T[] toArray(T[] a){
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    E elementData(int index){
        return (E) elementData[index];
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }
    public E set(int index,E element){
        rangeCheck(index);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    public boolean add(E e){
        ensureCapacityInternal(size+1);
        elementData[size++]=e;
        return true;
    }

    public void add(int index,E element){
        rangeCheckForAdd(index);
        ensureCapacityInternal(size+1);
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index] = element;
        size++;
    }

    // 移除一个元素，需要把空的哪个元素之后的元素 往前移动
    public E remove(int index){
        rangeCheck(index);
        modCount++;
        E oldValue = elementData(index);
        int numMoved = size-index-1;
        if(numMoved>0)
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        elementData[--size] = null;
        return oldValue;
    }

    public boolean remove(Object o){
        if(o==null){
            for (int i = 0; i < size; i++) {
                if(elementData[i]==null){
                    fastRemove(i);
                    return true;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if(o.equals(elementData[i])){
                    fastRemove(i);
                    return true;
                }

            }
        }
        return false;
    }

    private void fastRemove(int index){
        modCount++;
        int numMoved = size - index - 1;
        if(numMoved>0)
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        elementData[--size]=null;
    }

    public void clear(){
        for (int index = 0; index < size; index++) {
            elementData[index] =null;
        }
        size = 0 ;
    }

    public boolean addAll(Collection<? extends E> c){
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size+numNew);
        System.arraycopy(a,0,elementData,size,numNew);
        size += numNew;
        return numNew !=0;

    }

    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);  // Increments modCount

        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + numNew,
                    numMoved);

        System.arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    protected void removeRange(int fromIndex, int toIndex) {
        rangeCheck(fromIndex);
        rangeCheck(toIndex);
        modCount++;
        int numMoved = size - toIndex;
        if(numMoved>0){
            System.arraycopy(elementData,toIndex,elementData,fromIndex,numMoved);
        }
        int newSize = size - (toIndex-fromIndex);
        for (int index = newSize; index < size; index++) {
            elementData[index] = null;
        }
        size = newSize;
    }


    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }


    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    public boolean removeAll(Collection<?> c){
        Objects.requireNonNull(c);
        return false;
    }
    private boolean batchRemove(Collection<?> c, boolean complement) {
        final Object[] elementData = this.elementData;
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < size; r++)
                if (c.contains(elementData[r]) == complement)
                    elementData[w++] = elementData[r];
        } finally {
            // Preserve behavioral compatibility with AbstractCollection,
            // even if c.contains() throws.
            if (r != size) {
                System.arraycopy(elementData, r,
                        elementData, w,
                        size - r);
                w += size - r;
            }
            if (w != size) {
                // clear to let GC do its work
                for (int i = w; i < size; i++)
                    elementData[i] = null;
                modCount += size - w;
                size = w;
                modified = true;
            }
        }
        return modified;
    }

    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{
        // Write out element count, and any hidden stuff
        int expectedModCount = modCount;
        s.defaultWriteObject();

        // Write out size as capacity for behavioural compatibility with clone()
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (int i=0; i<size; i++) {
            s.writeObject(elementData[i]);
        }

        if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        elementData = EMPTY_ELEMENTDATA;

        // Read in size, and any hidden stuff
        s.defaultReadObject();

        // Read in capacity
        s.readInt(); // ignored

        if (size > 0) {
            // be like clone(), allocate array based upon size not capacity
            ensureCapacityInternal(size);

            Object[] a = elementData;
            // Read in all elements in the proper order.
            for (int i=0; i<size; i++) {
                a[i] = s.readObject();
            }
        }
    }

}
