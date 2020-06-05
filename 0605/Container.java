package T1;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Container implements Collection<Object> {
    //默认初始容量
    private  static final int DEFAULT_INITIAL_CAPACITY = 1 << 4 ;
    //默认最大容量
    private static final int MAXIMUM_CAPACITY = 1 << 30 ;
    //默认加载因子
    private static final float DEFAULT_LOAD_FACTOR = 0.75f ;
    //表示容器中某个元素尚未使用的标志
    private static final Object UNUSED = new Object() ;
    //用来引用数组的变量
    private Object[] elements;
    //用来表示容器中元素个数
    private int count;
    //用来表示扩容比例的变量
    private float loadFactor;
    public Container(int initialCapacity ,float loadFactor){
        if (initialCapacity<0 || initialCapacity>MAXIMUM_CAPACITY){
            RuntimeException ex =new RuntimeException("初始容量在[ 0 +" + MAXIMUM_CAPACITY +"] 之间");
            throw ex;
        }
        if (loadFactor<=0||loadFactor>=1){
            RuntimeException ex =new RuntimeException("加载因子在（ 0 ，1）之间的浮点数");
            throw ex;
        }
        this.elements = new Object[initialCapacity];
        this.loadFactor =loadFactor;
    }
    public Container(int initialCapacity){
        this(initialCapacity,DEFAULT_LOAD_FACTOR);
    }
    public Container(){
        this(DEFAULT_INITIAL_CAPACITY,DEFAULT_LOAD_FACTOR);
    }

    private void mark(){
        Arrays.fill(elements,UNUSED);
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count ==0;
    }

    @Override
    public boolean contains(Object o) {
        Object temp;
        for (int i = 0; i <count ; i++) {
            temp =elements[i];
            if (temp==o){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements,count);
    }

    @Override
    public boolean add(Object e) {
        elements[count++ ] =e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int x = this.indexOf(o);
        if (x!=-1) {
            System.arraycopy(elements,x+1,elements,x,count-x-1);
            elements[count-1] =UNUSED;
            count--;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        this.mark();;
        this.count=0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> e = c.iterator();
        while (e.hasNext()) {
            if (!contains(e.next()))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Object> c) {
       Iterator<?> e =c.iterator();
       while(e.hasNext()){
           add(e.next());
       }
       return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> e = c.iterator();
        while (e.hasNext()){
            remove(e.next());
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Iterator<?> e = c.iterator();
        while (e.hasNext()){
            for (int i=0;i<count;i++){
                if (elements[i]!=e.next()){
                    System.arraycopy(elements,i+1,elements,i,count-i-1);

                    elements[count-1] =UNUSED;
                    count--;
                }

            }
        }
        return true;

    }

    public int indexOf(Object o){
        for (int i = 0; i <count ; i++) {
            Object e=elements[i];
            if (e == o){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        StringBuilder builder =new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(elements[i] + "\n" );
        }
        return builder.toString();
    }

    @Override
    public Iterator<Object> iterator() { // 【不去实现】
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) { // 【不去实现】
        return null;
    }

}