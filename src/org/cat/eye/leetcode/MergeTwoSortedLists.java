package org.cat.eye.leetcode;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode result = new ListNode();
        ListNode resultTmp = result;

        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                resultTmp.val = list1.val;
                list1 = list1.next;
            } else {
                resultTmp.val = list2.val;
                list2 = list2.next;
            }

            ListNode tmp = new ListNode();
            resultTmp.next = tmp;
            resultTmp = tmp;
        }

        while (list1 != null) {
            resultTmp.val = list1.val;

            list1 = list1.next;

            if (list1 != null) {
                ListNode tmp = new ListNode();
                resultTmp.next = tmp;
                resultTmp = tmp;
            }
        }

        while (list2 != null) {
            resultTmp.val = list2.val;

            list2 = list2.next;

            if (list2 != null) {
                ListNode tmp = new ListNode();
                resultTmp.next = tmp;
                resultTmp = tmp;
            }
        }

        return result;
    }

}
