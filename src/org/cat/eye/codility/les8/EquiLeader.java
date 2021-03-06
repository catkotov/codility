package org.cat.eye.codility.les8;

/*
A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1
and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:

 - 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 - 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.

The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

 - N is an integer within the range [1..100,000];
 - each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].

 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class EquiLeader {

    public static void main(String[] argv) {
        int[] A = {4,3,4,4,4,2};

        EquiLeader equiLeader = new EquiLeader();
        System.out.println("result: " + equiLeader.solution(A));
    }

    public int solution(int[] A) {

        int result = 0;

        Integer leader = getLeader(A);
        if (null == leader) {
            return 0;
        }

        for (int i = 0; i < A.length; i++) {
            int[] B = Arrays.copyOfRange(A, 0, i+1);
            int[] C = Arrays.copyOfRange(A, i+1, A.length);

            if (isLeader(B, leader) && isLeader(C, leader)) {
                result++;
            }
        }

        return result;
    }

    private Integer getLeader(int[] A) {

        Deque<Integer> stack = new LinkedList<>();

        for (int a : A) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else {
                if (stack.getFirst() != a) {
                    stack.pollFirst();
                } else {
                    stack.push(a);
                }
            }
        }

        int candidate;
        Integer leader = null;

        if (!stack.isEmpty()) {
            candidate = stack.pollFirst();
        } else
            return null;

        if (isLeader(A, candidate))
            leader = candidate;

        return leader;
    }

    private boolean isLeader(int[] A, int candidate) {

        int count = 0;
        for (int j : A) {
            if (j == candidate) {
                count++;
            }
        }
        return count > A.length / 2;
    }

}
