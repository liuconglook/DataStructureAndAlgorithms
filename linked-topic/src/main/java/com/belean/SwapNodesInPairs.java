package com.belean;

/**
 * 24.两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
 */
public class SwapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void print(ListNode head) {
        if(head != null) {
            System.out.print(head.val + "->");
            ListNode currentNode = head;
            while((currentNode = currentNode.next) != null) {
                System.out.print(currentNode.val + "->");
            }
            System.out.println("NULL");
        }
    }

    public static void main(String[] args) {
        
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));

        print(swapPairs01(head));
        
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        print(swapPairs02(head2));
    }
    
    /**
     * （1）迭代求解
     */
    public static ListNode swapPairs01(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode currentNode = newNode;
        while(currentNode.next != null && currentNode.next.next != null) {
            ListNode next1 = currentNode.next;
            ListNode next2 = currentNode.next.next;
            currentNode.next = next2;
            next1.next = next2.next;
            next2.next = next1;
            currentNode = next1;
        }

        return newNode.next;
    }
    
    /**
     * （2）迭代求解
     * @param head
     * @return
     */
    public static ListNode swapPairs02(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs02(newHead.next);
        newHead.next = head;
        return newHead;
    }
}