package com.belean.array;

import java.util.Arrays;

/**
 * ArrayList
 * E(Element)泛型，表示元素类型
 */
public class ArrayList<E> {

    private E[] data; // 数组

    private int size; // 数组大小

    private static final int defaultCapacity = 10; // 默认数组大小

    public ArrayList(){
        this(defaultCapacity);
    }

    public ArrayList(int capacity){
        if(capacity < 0)
            throw new IllegalArgumentException();
        data = (E[]) new Object[capacity];
    }

    public int size(){
        return size;
    }

    // 添加元素，可链式添加，平均时间复杂度O(1)
    public ArrayList<E> add(E e){
        if(size == data.length){ // 数组满了，进行扩容，保证其容量
            ensureCapacity();
        }
        data[size++] = e;
        return this;
    }

    // 扩容两倍
    private void ensureCapacity() {
        E[] newData = (E[]) new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    // 根据索引删除O(n)
    public void remove(int index){
        if(--size != index){ // 删除最后一个元素不需要搬移操作
            System.arraycopy(data, index + 1, data, index, size - index);
        }
        data[size] = null; // 有没有搬移，都需要将最后一个元素位置清空
        
    }

    // 根据元素删除O(n)
    public void remove(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)){
                if(--size != i)  // 删除最后一个元素不需要搬移操作
                    System.arraycopy(data, i + 1, data, i, size - i);
                data[size] = null; // 有没有搬移，都需要将最后一个元素位置清空
                break;
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
    
}