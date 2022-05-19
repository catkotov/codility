package org.cat.eye.leetcode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (null == head)
            return null;
        else if (null == head.next)
            return head;

        return swap(head, head);
    }

    private ListNode swap(ListNode node, ListNode prev) {

        ListNode n3 = null;

        if (node.next != null)
            n3 = node.next.next;

        ListNode n2 = node.next;

        ListNode result;

        if (n2 != null) {
            n2.next = node;
            result = n2;
            node.next = null;
        } else {
            result = node;
        }

        if (n3 != null) {
            prev.next = swap(n3, node);
        }

        return result;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
