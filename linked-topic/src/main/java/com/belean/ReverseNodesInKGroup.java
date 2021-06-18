package com.belean;

/**
 * 25.K个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class ReverseNodesInKGroup {

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
        
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        int k = 3;
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        print(reverseKGroup(head2, k));
        //print(reverseNode(head2.next, head2.next.next.next));
        //print(head2);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode currentNode = head;
        ListNode trail = null;
        ListNode prevNode = null;
        if(k < 2) {
            return head;
        }
        // 遍历每个需要反转的k块
        while((trail = getKNode(currentNode, k)) != null) {
            ListNode reverseNode = reverseNode(currentNode, trail.next);
            // 存储第一个块
            if(prevNode == null) {
                prevNode = reverseNode;
            }else{ // 链接其他块
                // 遍历到当前块的尾节点
                while(head.next != currentNode) {
                    head = head.next;
                }
                // 链接下一个块
                head.next = reverseNode; 
                head = reverseNode;
            }
            // 迭代
            currentNode = currentNode.next;
        }
        return prevNode;
    }
    // 获取尾结点
    public static ListNode getKNode(ListNode head, int k) {
        if(k == 1 || head == null) {
            return head;
        }
        return getKNode(head.next, --k);
    }
    // 根据头尾反转链表
    public static ListNode reverseNode(ListNode head, ListNode trail) {
        if(head.next == trail) {
            return head;
        }
        ListNode reverseNode = reverseNode(head.next, trail);
        ListNode currentNode = reverseNode;
        while(currentNode.next != trail) {
            currentNode = currentNode.next;
        }
        currentNode.next = head;
        head.next = trail;
        return reverseNode;
    }

    // 1->2->3->null 3->null 3->2->1->2->... 3->2->1->null
    // 2->3->null 3->null 3->2->3->... 3->2->null
    // 3->null 3->null
    // 

}
