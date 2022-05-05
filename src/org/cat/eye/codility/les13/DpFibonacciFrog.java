package org.cat.eye.codility.les13;

import java.util.ArrayList;
import java.util.List;

public class DpFibonacciFrog {

    public int solution(int[] A) {

        int[] DP = new int[A.length + 2];
        for (int i = 1; i < DP.length; i++)
            DP[i] = 200_000;
        DP[0] = 0;

        Integer[] fib = getFibonacci(A.length);

        for (int i = 1; i <= A.length + 1; i++) {
            for (int j = 0; j < fib.length; j++) {
                if ((i == A.length +1 || A[i-1] == 1) && i - fib[j] >= 0) {
                    DP[i] = Math.min(DP[i], 1 + DP[i - fib[j]]);
                }
            }
        }

        if (DP[A.length + 1] != 200_000)
            return DP[A.length + 1];
        else
            return -1;
    }

    private Integer[] getFibonacci(int n) {

        List<Integer> fibLst = new ArrayList<>();
        fibLst.add(1);
        fibLst.add(2);

        int i = 1;

        while (fibLst.get(i) + fibLst.get(i-1) <= n + 1) {
            fibLst.add(fibLst.get(i) + fibLst.get(i-1));
            i++;
        }

        Integer[] fib = new Integer[fibLst.size()];

        return fibLst.toArray(fib);
    }

    public static void main(String[] argv) {
        int[] A = {1};
//        int[] A = {0,1,0,1,1,0,1,0,1,0,0};
//        int[] A1 = {0,1,0,0,0,0,0,0,1,0,0};

        DpFibonacciFrog frog = new DpFibonacciFrog();
        System.out.println("result: " + frog.solution(A));
        //       System.out.println("result: " + frog.solution(A1));
    }

}
