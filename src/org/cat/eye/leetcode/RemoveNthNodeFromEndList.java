package org.cat.eye.leetcode;

public class RemoveNthNodeFromEndList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode delPointer = new ListNode(0, head);
        ListNode end = delPointer;

        int i = 0;

        while (i < n) {
            end = end.next;
            i++;
        }

        while (end.next != null) {
            end = end.next;
            delPointer = delPointer.next;
        }



//        if (delPointer.next == head && head == end) {
//            head = null;
//        } else if (delPointer.next == head) {
//            delPointer.next.next = null;
//            delPointer.next = end;
//            head = delPointer.next;
//        } else if (delPointer.next == end) {
//            delPointer.next = null;
//        } else {
//            delPointer.next.next = null;
//            delPointer.next = end;
//        }

        return head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
