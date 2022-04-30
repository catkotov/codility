package org.cat.eye.codility;

public class TapeEquilibrium {

    public static int solution(int[] A) {

        int sum2 = 0;
        for (int k : A) {
            sum2 += k;
        }

        int result = Math.abs(2*A[0] - sum2);

        int sum1 = 0;

        for (int i = 0; i < A.length-1; i++) {
            sum1 += A[i];
            sum2 -= A[i];

            int tmp = Math.abs(sum1 - sum2);

            if (tmp <= result) {
                result = tmp;
            }
        }

        return result;
    }

}
