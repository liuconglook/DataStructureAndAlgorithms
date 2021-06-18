package com.belean;

import java.util.HashSet;
import java.util.Set;

/**
 * 142.环形链表II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 */
public class LinkedListCycleII {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        //head.next.next.next.next = head.next;

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2;

        ListNode head3 = new ListNode(1);

        ListNode detectNode = detectCycle01(head);
        System.out.println(detectNode == null?"null":detectNode.val);
        
        ListNode detectNode2 = detectCycle02(head);
        System.out.println(detectNode2 == null?"null":detectNode2.val);

    }

    /**
     * （1）哈希表求解
     * @param head
     * @return
     */
    public static ListNode detectCycle01(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        Set<ListNode> hashList = new HashSet<>();
        ListNode currentNode = head;
        hashList.add(currentNode);
        while((currentNode = currentNode.next) != null) {
            if(!hashList.add(currentNode)) {
                return currentNode;
            }
        }
        return null;
    }

    /**
     * （2）快慢指针
     * @param head
     * @return
     */
    public static ListNode detectCycle02(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while(fast != null) {
            slow = slow.next;
            if(fast.next != null) {
                fast = fast.next.next;
            }else{
                return null;
            }
            if(fast == slow) {
                ListNode ptr = head;
                while(ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

}
