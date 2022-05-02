package org.cat.eye.codility.les5;

/*
A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N,
is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q)
is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice.
To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

 - slice (1, 2), whose average is (2 + 2) / 2 = 2;
 - slice (3, 4), whose average is (5 + 1) / 2 = 3;
 - slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.

The goal is to find the starting position of a slice whose average is minimal.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average.
If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

 - N is an integer within the range [2..100,000];
 - each element of array A is an integer within the range [−10,000..10,000].

 */

public class MinAvgTwoSlice {

    public static int solution(int[] A) {

        int result = 0;

        int[] pref = MinAvgTwoSlice.getPrefixSums(A);

        double minAvg = Double.MAX_VALUE;
        int start = 0;

        while (start < pref.length - 2) {
            for (int i = start + 2; i < pref.length; i++) {
                double avg = ((double) (pref[i] - pref[start])) / (i - start);
                if (avg < minAvg) {
                    minAvg = avg;
                    result = start;
                }
            }

            start++;
        }

        return result;
    }

    public static int[] getPrefixSums(int[] A) {

        int[] result = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            result[i+1] = result[i] + A[i];
        }

        return result;
    }

    public static void main(String[] argv) {

        int[] A = {4, 2, 2, 5, 1, 5, 8};

        System.out.println("result: " + solution(A));
    }

}
