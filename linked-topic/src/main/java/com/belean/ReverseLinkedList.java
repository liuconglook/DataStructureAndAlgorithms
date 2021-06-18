package com.belean;

/**
 * 206.反转链表
 * - 反转一个单链表。
 * - 进阶: 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList {

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

    public static void main( String[] args ) {
        // 初始化链表：1->2->3->4->5->null
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));

        print(reverseList01(head));

        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        print(reverseList02(head2));

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

    /**
     * （1）递归求解
     * @param head
     * @return
     */
    public static ListNode reverseList01(ListNode head) {
        // 处理边界条件
        if(head == null){
            return null;
        }

        // 递归到最后一个，直接返回
        if(head.next == null) {
            return head;
        }
        // 获取递归返回的
        ListNode reverseNode = reverseList01(head.next);
        // 迭代到最后
        ListNode currentNode = reverseNode;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        // 赋值上一个节点
        currentNode.next = head;
        head.next = null;
        // 返回最后一个元素，也就是反转后的头结点
        return reverseNode;
    }

    /**
     * 迭代求解
     * @param head
     * @return
     */
    public static ListNode reverseList02(ListNode head) {

        ListNode prevNode = null;
        ListNode currentNode = head;
        while(currentNode != null) {
            ListNode next = currentNode.next; // 存储下一个元素，为什么存储，因为要反转了
            
            currentNode.next = prevNode; // 反转，指向上一个元素

            prevNode = currentNode; // 上一个元素 变为 当前元素 因为要迭代 等待被反转
            
            currentNode = next; // 当前元素 变为 下一个元素 因为要迭代
        }
        return prevNode;
    }
}
