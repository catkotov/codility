package org.cat.eye.codility.les15;

/*
A non-empty array A consisting of N numbers is given. The array is sorted in non-decreasing order.
The absolute distinct count of this array is the number of distinct absolute values among the elements of the array.

For example, consider array A such that:

  A[0] = -5
  A[1] = -3
  A[2] = -1
  A[3] =  0
  A[4] =  3
  A[5] =  6
The absolute distinct count of this array is 5,
because there are 5 distinct absolute values among the elements of this array, namely 0, 1, 3, 5 and 6.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N numbers, returns absolute distinct count of array A.

For example, given array A such that:

  A[0] = -5
  A[1] = -3
  A[2] = -1
  A[3] =  0
  A[4] =  3
  A[5] =  6
the function should return 5, as explained above.

Write an efficient algorithm for the following assumptions:

 - N is an integer within the range [1..100,000];
 - each element of array A is an integer within the range [−2,147,483,648..2,147,483,647];
 - array A is sorted in non-decreasing order.

 */

public class AbsDistinct {

    public int solution(int[] A) {

        if (A.length == 0)
            return 0;
        if (A.length == 1)
            return 1;

        int n = A.length;
        int back = 0, front = n-1;

        return getDistinct(A, back, front);
    }

    private int getDistinct(int[] A, int back, int front) {

        int count = 0;
        int n = A.length;

        while (back < front) {
            if (Math.abs((long) A[back]) != Math.abs((long) A[front])) {
                count += 1;
                if (Math.abs((long) A[back]) > Math.abs((long) A[front])) {
                    do {
                        back += 1;
                    } while ((long) A[back] == (long) A[back - 1] && back < front);
                    if (back == front) count++;
                }
                if (Math.abs((long) A[back]) < Math.abs((long) A[front])) {
                    do {
                        front -= 1;
                    } while ((long) A[front] == (long) A[front + 1] && front > back);
                    if (back == front) count++;
                }
            } else {
                count++;
                do {
                    back += 1;
                } while ((long) A[back] == (long) A[back-1] && back < front);
                do {
                    front -= 1;
                } while ((long) A[front] == (long) A[front+1] && front > back);
                if (back == front) count++;
            }
        }

        return count;
    }

    public static void main(String[] argv) {

//        int[] A = {-5, -3, -1, 0, 3, 6};
//        int[] A = {-5, -3};
//        int[] A = {-11, -5, -3, -1, 0, 0, 0, 0, 3, -5, 6, 9, 11};
        int[] A = {-2147483648, -1, 0, 1};
        AbsDistinct absDistinct = new AbsDistinct();

        System.out.println("result: " + absDistinct.solution(A));

    }

}
