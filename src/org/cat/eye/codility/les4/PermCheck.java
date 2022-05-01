package org.cat.eye.codility.les4;

/*
A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

 - N is an integer within the range [1..100,000];
 - each element of array A is an integer within the range [1..1,000,000,000].

 */

public class PermCheck {

    public static int solution(int[] A) {

        int[] count = new int[A.length + 1];
        int steps = 0;

        for (int a : A) {
            if (a == 0 || a > A.length || count[a] != 0)
                return 0;
            count[a]++;
            steps++;
        }

        if (steps == A.length)
            return 1;
        else
            return 0;
    }

    public static void main(String[] argv) {
        int[] A = {4, 1, 3, 2};
        System.out.println("result: " + solution(A));

        int[] B = {4, 1, 3};
        System.out.println("result: " + solution(B));
    }

}
