package org.cat.eye.leetcode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (null == head)
            return null;
        else if (null == head.next)
            return head;
        else if (null == head.next.next) {
            ListNode n2 = head.next;
            head.next = null;
            n2.next = head;
        }

        return swap(head, head);
    }

    private ListNode swap(ListNode node, ListNode prev) {

        if (node.next != null) {

            ListNode n3 = node.next.next;
            ListNode n2 = node.next;

            n2.next = node;
            node.next = null;

            if (n3 != null) {
                prev.next = swap(n3, n3);
            } else {
                prev.next = node;
            }

            return n2;

        } else {
            return node;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] agrv) {
//        ListNode n7 = new ListNode(7, null);
//        ListNode n6 = new ListNode(6, n7);
//        ListNode n5 = new ListNode(5, n6);
//        ListNode n4 = new ListNode(4, n5);
        ListNode n4 = new ListNode(4, null);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);

        SwapNodesInPairs sw = new SwapNodesInPairs();
        ListNode result = sw.swapPairs(n1);
    }


}
