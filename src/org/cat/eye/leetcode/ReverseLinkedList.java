package org.cat.eye.leetcode;

public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode tmp = current.next;

            current.next = prev;
            prev = current;

            current = tmp;
        }

        return prev;
    }

    public static ListNode reverseListRecursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return p;
    }
}
