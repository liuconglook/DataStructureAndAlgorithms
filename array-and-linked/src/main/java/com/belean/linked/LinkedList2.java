package com.belean.linked;

/**
 * LinkedList 单链表，增加一个哨兵节点
 * E(Element)泛型，表示元素类型
 */
public class LinkedList2<E> {
    
    private Node<E> head = new Node<E>(null); // 头指针，也就是链表的开始节点

    private int size; // 链表大小

    // 尾插法
    public LinkedList2<E> add(E e){
        if(e == null){
            throw new IllegalArgumentException();
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
                currentNode.next = currentNode.next.next;
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

}
