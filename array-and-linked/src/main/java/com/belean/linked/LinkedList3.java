package com.belean.linked;

/**
 * LinkedList 双向链表
 * E(Element)泛型，表示元素类型
 */
public class LinkedList3<E> {
    
    private Node<E> head = new Node<E>(null); // 头指针，也就是链表的开始节点

    private int size; // 链表大小

    // 尾插法
    public LinkedList3<E> add(E e){
        if(e == null){
            throw new IllegalArgumentException();
        }

        Node<E> currentNode = head; // 当前节点
        // 遍历到最后
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<E>(e);
        currentNode.next.pre = currentNode;
        size++;
        return this;
    }

    // 头插法
    public LinkedList3<E> addFirst(E e) {
        if(e == null){
            throw new IllegalArgumentException();
        }

        Node<E> newNode = new Node<E>(e);

        newNode.next = head.next;
        newNode.pre = head;
        head.next.pre = newNode;
        head.next = newNode;
        ++size;
        return this;
    }

    // 根据索引插入
    public LinkedList3<E> insert(int index, E e) {
        if(e == null){
            throw new IllegalArgumentException();
        }
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> newNode = new Node<E>(e);

        int i = 0;
        Node<E> currentNode = head;
        while((currentNode = currentNode.next) != null) {
            if(index == i) {
                newNode.next = currentNode;
                newNode.pre = currentNode.pre;
                currentNode.pre.next = newNode;
                currentNode.pre = newNode;
                ++size;
                break;
            }
            ++i;
        }

        return this;
    }

    // 根据索引删除
    public void remove(int index){
        if(index < 0){
            throw new IndexOutOfBoundsException();
        }

        Node<E> currentNode = head; // 当前节点
        int i = 0;
        while(currentNode.next != null){
            if(i == index){ // 找到索引位置节点
                if(i == size-1){ // 如果是最后一个元素
                    currentNode.next = null;
                }else{
                    currentNode.next.next.pre = currentNode;
                    currentNode.next = currentNode.next.next;
                }
                size--;
                break;
            }
            i++;
            currentNode = currentNode.next;
        }
    }

    // 根据元素删除
    public void remove(E e){
        if(e == null || size == 0){
            return;
        }

        Node<E> currentNode = head; // 当前节点
        while(currentNode.next != null){
            if(e.equals(currentNode.next.data)){
                if(currentNode.next.next == null){
                    currentNode.next = null;
                }else{
                    currentNode.next.next.pre = currentNode;
                    currentNode.next = currentNode.next.next;
                }
                size--;
                break;
            }
            currentNode = currentNode.next;
        }
    }

    // 元素节点
    class Node<E> {
        E data;
        Node<E> next;
        Node<E> pre;

        Node(E e){
            data = e;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Node<E> currentNode = head; // 当前节点
        while((currentNode = currentNode.next) != null){
            str.append(currentNode.data + ",");
        }
        if(currentNode != head.next)
            str.delete(str.lastIndexOf(","), str.length());
        str.append("]");
        return str.toString();
    }

    // 反向打印
    public String reversePrint() {
        System.out.println(head.next.next.next.next.next.next.next.next.pre.pre.pre.pre.pre.pre.pre.pre.data);
        Node<E> currentNode = head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }

        Node<E> lastNode = currentNode;
        StringBuilder str = new StringBuilder("[");
        while(currentNode.pre != null){
            str.append(currentNode.data + ",");
            currentNode = currentNode.pre;
        }
        if(currentNode != lastNode.next)
            str.delete(str.lastIndexOf(","), str.length());
        str.append("]");
        return str.toString();
    }
}
