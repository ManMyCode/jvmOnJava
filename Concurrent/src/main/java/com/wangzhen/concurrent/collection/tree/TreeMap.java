package com.wangzhen.concurrent.collection.tree;

import java.util.*;

public class TreeMap<K,V>extends AbstractMap<K,V>
        implements NavigableMap<K,V>,Cloneable,java.io.Serializable {

    // 用于维护 树里面的顺序
    private final Comparator<? super K> comparator;
    // 被transient 的对象不会被序列化到硬盘上，只会存在内存中
    private transient Entry<K,V> root;

    // tree 的 entries 的数量
    private transient int size = 0;

    // tree 被修改的次数
    private transient int modCount = 0;

    // 不 传入排序规则 ，按照默认规则排序
    public TreeMap(){
        comparator = null;
    }

    public TreeMap(Comparator<? super K> comparator){
        this.comparator = comparator;
    }

    public TreeMap(Map<? super K,?extends V> m){
        comparator = null;
       // putAll(m);
    }

    public TreeMap(SortedMap<K, ? extends V> m) {
        comparator = m.comparator();
//        try {
//            buildFromSorted(m.size(), m.entrySet().iterator(), null, null);
//        } catch (java.io.IOException cannotHappen) {
//        } catch (ClassNotFoundException cannotHappen) {
//        }
    }

    public int size(){
        return size;
    }

    public boolean containsKey(Object key){

        return  getEntry(key) !=null;
    }

    public boolean containsValue(Object value) {
        for(Entry<K,V> e = getFirstEntry();e!=null;e=successor(e)){
            if(valEquals(value,e.value))
                return true;
        }
        return false;
    }

    public V get(Object key){
        Entry<K,V>p= getEntry(key);
        return p==null ? null :p.value;
    }

    public Comparator<? super K> comparator (){
        return comparator;
    }

    public K firstKey(){
        return key(getFirstEntry());
    }

    public K lastKey(){
        return key(getLastEntry());
    }

    public void putAll(Map<? extends K, ? extends V> map) {

    }

    final Entry<K,V> getEntry(Object key){
        if(comparator!=null){
            return getEntryUsingComparator(key);
        }

        if(key == null){
            throw new NullPointerException();
        }
        Comparable<? super K> k = (Comparable<? super K>) key;
        Entry<K,V> p =root;
        while (p!=null){
            int cmp  = k.compareTo(p.key);
            if(cmp<0){
                p = p.left;
            }if(cmp>0) {
                p = p.right;
            }else {
                return p;
            }

        }
        return null;
    }

    final Entry<K,V> getEntryUsingComparator(Object key) {
        Comparator<? super K> cpt = comparator;
        // 如果比较器不为空 那么就使用 自定义实现的 比较器
        if(comparator !=null){
            K k = (K) key;
            Entry<K,V> p = root;
            while (p!=null){
                int cmp = cpt.compare(k,p.key);
                if(cmp<0){
                    p = p.left;
                }else if(cmp>0){
                    p=p.right;
                }else {
                    return p;
                }
            }
        }
        return null;
    }



    final Entry<K,V> getCeilingEntry(K key) {
        return null;
    }

    final Entry<K,V> getFloorEntry(K key) {
        return null;
    }

    final Entry<K,V> getHigherEntry(K key) {
        return null;
    }

    final Entry<K,V> getLowerEntry(K key) {
        return null;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     *
     * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     *         (A {@code null} return can also indicate that the map
     *         previously associated {@code null} with {@code key}.)
     * @throws ClassCastException if the specified key cannot be compared
     *         with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *         and this map uses natural ordering, or its comparator
     *         does not permit null keys
     */
    public V put (K key,V value){
        Entry<K,V> p = root;
        // 如果root 根节点是null
        if(p==null){
            p = new Entry<>(key,value,null);
            root = p;
            size++;
            modCount++;
            return null;
        }
        int cmp =0;
        // 用于记录的父节点
        Entry<K,V> parent = null;
        if(comparator != null){
            while (p!=null){
                parent = p;
                cmp = comparator.compare(key,p.key);
                if(cmp<0){
                    p = p.left;
                }else if(cmp >0) {
                    p = p.right;
                }else {
                    // 如果 有一样的 key 那么直接替换掉 返回，
                    return  p.setValue(value);
                }
            }
        }else {
            Comparable k = (Comparable) key;
            while (p!=null){
                parent = p;
                cmp = k.compareTo(p.key);
                if(cmp<0){
                    p = p.left;
                }else if(cmp > 0 ){
                    p = p.right;
                }else {
                    return p.setValue(value);
                }
            }
        }
        // 退出上面的循环后 ，p 为父节点 cmp 保证了 新节点是父节点还是子节点
        Entry<K,V> entry = new Entry<>(key,value,parent);
        if(cmp<0){
            parent.left = entry;
        }else if(cmp >0){
            parent.right = entry;
        }
        size++;
        modCount++;
        fixAfterInsertion(entry);
        return null;
    }

    // 删除节点
    public V remove(Object key){
        Entry<K,V> p = getEntry(key);
        if(p==null)
            return null;
        V oldValue = p.value;
        return oldValue;
    }

    public void clear(){
        modCount++;
        size=0;
        root=null;
    }
    public Object clone(){
        return null;
    }

    public Map.Entry<K,V> firstEntry() {
        return exportEntry(getFirstEntry());
    }

    public Map.Entry<K,V> lastEntry() {
        return exportEntry(getLastEntry());
    }

    public Map.Entry<K,V> pollFirstEntry() {
        return null;
    }
    public Map.Entry<K,V> pollLastEntry() {
        return null;
    }

    @Override
    public NavigableMap<K, V> descendingMap() {
        return null;
    }

    @Override
    public NavigableSet<K> navigableKeySet() {
        return null;
    }

    @Override
    public NavigableSet<K> descendingKeySet() {
        return null;
    }

    @Override
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        return null;
    }

    @Override
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        return null;
    }

    @Override
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        return null;
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return null;
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return null;
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return null;
    }

    public Map.Entry<K,V> lowerEntry(K key) {
        return exportEntry(getLowerEntry(key));
    }

    public K lowerKey(K key) {
        return keyOrNull(getLowerEntry(key));
    }

    public Map.Entry<K,V> floorEntry(K key) {
        return exportEntry(getFloorEntry(key));
    }

    public K floorKey(K key) {
        return keyOrNull(getFloorEntry(key));
    }

    public Map.Entry<K,V> ceilingEntry(K key) {
        return exportEntry(getCeilingEntry(key));
    }

    public K ceilingKey(K key) {
        return keyOrNull(getCeilingEntry(key));
    }

    public Map.Entry<K,V> higherEntry(K key) {
        return exportEntry(getHigherEntry(key));
    }

    public K higherKey(K key) {
        return keyOrNull(getHigherEntry(key));
    }





    // Red-black mechanics
    private static final boolean RED   = false;
    private static final boolean BLACK = true;
    static final class Entry<K,V> implements Map.Entry<K,V>{
        K key;
        V value;
        Entry<K,V> left;
        Entry<K,V> right;
        Entry<K,V> parent;
        boolean color = BLACK;

        Entry(K key,V value,Entry<K,V> parent){
            this.key = key;
            this.value = value;
            this.parent = parent;
        }


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o){
            if(!(o instanceof  Map.Entry))
                return false;
            Map.Entry<?,?> e = (Map.Entry<?,?>) o;

            return valEquals(key,e.getKey())&& valEquals(value,e.getValue());
        }

        public int hashCode(){
            int keyHash = (key==null ? 0 : key.hashCode());
            int valueHash = (value==null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }
        public String toString (){
            return key +"="+value;
        }
    }


    /**
     * Returns the first Entry in the TreeMap (according to the TreeMap's
     * key-sort function).  Returns null if the TreeMap is empty.
     */
    final Entry<K,V> getFirstEntry(){
        Entry<K,V> p = root;
        if(p!=null){
            while ((p.left != null))
                p = p.left;
        }
        return p;
    }

    /**
     * Returns the last Entry in the TreeMap (according to the TreeMap's
     * key-sort function).  Returns null if the TreeMap is empty.
     */
    final Entry<K,V> getLastEntry() {
        Entry<K,V> p = root;
        if(p!=null){
            while ((p.right!=null))
                p = p.right;
        }
        return p;
    }

    /**
     *       7
     *      / \
     *     4    9
     *    /\   / \
     *   2 5  8 11
     *
     * Returns the successor of the specified Entry, or null if no such.
     * 后继节点：大于当前节点的最小值
     */
    static <K,V> TreeMap.Entry<K,V> successor(Entry<K,V> t) {
        return null;
    }


    /**
     * Returns the predecessor of the specified Entry, or null if no such.
     * 前驱节点：小于当前节点的最大值
     */
    static <K,V> Entry<K,V> predecessor(Entry<K,V> t) {
        return null;
    }

    /**
     * Balancing operations.
     *
     * Implementations of rebalancings during insertion and deletion are
     * slightly different than the CLR version.  Rather than using dummy
     * nilnodes, we use a set of accessors that deal properly with null.  They
     * are used to avoid messiness surrounding nullness checks in the main
     * algorithms.
     */

    private static <K,V> boolean colorOf(Entry<K,V> p){
        return (p==null?BLACK:p.color);
    }

    private static <K,V> Entry<K,V> parentOf(Entry<K,V> p){
        return (p==null ? null : p.parent);
    }

    private static <K,V> void setColor(Entry<K,V> p,boolean c){
        if(p!=null)
            p.color=c;
    }

    private static <K,V> Entry<K,V> leftOf(Entry<K,V> p) {
        return (p == null) ? null: p.left;
    }

    private static <K,V> Entry<K,V> rightOf(Entry<K,V> p) {
        return (p == null) ? null: p.right;
    }





    final int compare(Object k1,Object k2){
        return comparator == null ? ((Comparable<? super  K>)k1).compareTo((K)k2): comparator.compare((K)k1,(K)k2);
    }

    static final boolean valEquals(Object o1, Object o2) {
        return (o1==null ? o2==null : o1.equals(o2));
    }

    /**
     * Return SimpleImmutableEntry for entry, or null if null
     */
    static <K,V> Map.Entry<K,V> exportEntry(TreeMap.Entry<K,V> e) {
        return (e == null) ? null :
                new SimpleImmutableEntry<>(e);
    }

    static <K,V> K keyOrNull(TreeMap.Entry<K,V> e){
        return e==null ? null :e.key;
    }

    static <K> K key(Entry<K,?> e){
        if(e==null){
            throw new NoSuchElementException();
        }
        return e.key;
    }

    private static final Object UNBOUNDED = new Object();

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set set = new HashSet();
        return  set;
    }

    // 节点左旋转
    private void reotateLeft(Entry<K,V> p){

    }

    // 节点右旋转
    private void rotateRight(Entry<K,V> p){

    }

    // 插入后调节红黑树
    /*
    1. 2-3-4树：新增元素+ 2节点合并（节点中只有一个元素） = 3节点（节点中有2个元素）
        红黑树：新增一个红色节点+黑色父亲节点=上黑下红（2节点）--------------不要调整

    2. 2-3-4树：新增元素+3节点合并（节点中有2个元素）=4节点(节点中有3个元素)
            这里有4种小情况（左3 ，右3，还有2个左中右不需要调整）-------------左3  ，右3需要调整，其余2个不需要调整
            红黑树：新增红色节点+上黑下红=排序后中间节点是黑色，两边节点都是红色（3节点）



     */
    private void fixAfterInsertion(Entry<K,V> x) {

        x.color = RED;
        // 本质上就是 父亲节点是黑色节点就不需要调整
        if(x!=null&&x!=root&&x.parent.color==BLACK){

        }
    }
    private void deleteEntry(Entry<K,V> p) {

    }

    private void fixAfterDeletion(Entry<K,V> x) {

    }






}
