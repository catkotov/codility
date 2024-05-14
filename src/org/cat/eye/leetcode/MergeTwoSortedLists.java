package org.cat.eye.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

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

    public static ListNode mergeTwoLists_2(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(0);
        ListNode point = head;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        if (o1.val > o2.val) {
                            return 1;
                        } else if (o1.val == o2.val) {
                            return 0;
                        } else {
                            return -1;
                        }
                    }
                }
        );

        if (list1 != null) {
            queue.add(list1);
        }
        if (list2 != null) {
            queue.add(list2);
        }

        while (!queue.isEmpty()) {
            point.next = queue.poll();
            point = point.next;
            if (point.next != null) {
                queue.add(point.next);
            }
        }
        return head.next;
    }

}
