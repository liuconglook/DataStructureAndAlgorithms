package com.belean.linked;

/**
 * LinkedList 单链表
 * E(Element)泛型，表示元素类型
 */
public class LinkedList<E> {
    
    private Node<E> head; // 头指针，也就是链表的开始节点

    private int size; // 链表大小

    // 尾插法
    public LinkedList<E> add(E e){
        if(e == null){
            throw new IllegalArgumentException();
        }

        if(head == null){
            head = new Node<E>(e);
            size++;
            return this;
        }

        Node<E> currentNode = head; // 当前节点
        // 遍历到最后
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<E>(e);
        size++;
        return this;
    }

    // 头插法
    public LinkedList<E> addFirst(E e) {
        if(e == null){
            throw new IllegalArgumentException();
        }

        Node<E> newHead = new Node<E>(e); // 新的头结点
        newHead.next = head;
        head = newHead;
        size++;

        return this;
    }

    // 根据索引插入
    public LinkedList<E> insert(int index, E e) {
        if(e == null){
            throw new IllegalArgumentException();
        }
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        Node<E> newNode = new Node<E>(e);

        if(index == 0) { // 插入到第一个
            newNode.next = head;
            head = newNode;
            size++;
            return this;
        }

        int i = 1;
        Node<E> currentNode = head;
        while(currentNode.next != null) {
            if(index == i) {
                break;
            }else{
                currentNode = currentNode.next;
                ++i;
            }
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        size++;

        return this;
    }

    // 根据索引删除
    public void remove(int index){
        if(index < 0 || size == 0){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){ // 删除头节点
            if(head.next != null){ // 后继有人
                head = head.next;
            }else{ // 第一个也是最后一个节点
                head = null;
            }
            return;
        }

        Node<E> currentNode = head; // 当前节点
        int i = 1;
        while(currentNode.next != null){
            if(i == index){ // 找到索引位置节点
                if(index == size-1){
                    currentNode.next = null;
                }else{
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
        Node<E> preNode = null; // 上一节点
        while(currentNode != null){
            if(e.equals(currentNode.data)){
                if(preNode == null){
                    head = null;
                }else{
                    preNode.next = currentNode.next;
                }
                size--;
                break;
            }
            preNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    // 元素节点
    class Node<E> {
        E data;
        Node<E> next;

        Node(E e){
            data = e;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Node<E> currentNode = head; // 当前节点
        while(currentNode != null){
            str.append(currentNode.data + ",");
            currentNode = currentNode.next;
        }
        if(currentNode != head)
            str.delete(str.lastIndexOf(","), str.length());
        str.append("]");
        return str.toString();
    }

}
