package org.cat.eye.algorithms.sort.quick;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {3,1,2,9,8,4,7,5,0,6};
        System.out.println("source = " + Arrays.toString(a));
        int[] result = sort(a);
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] sort(int[] a) {
        if (a.length < 2) {
            return a;
        } else {
            Deque<Integer> less = new ArrayDeque<>();
            Deque<Integer> greater = new ArrayDeque<>();
            int pivot = a.length / 2;
            for (int i = 0; i < a.length; i++) {
                if (i != pivot) {
                    if (a[i] < a[pivot]) {
                        less.push(a[i]);
                    } else {
                        greater.push(a[i]);
                    }
                }
            }
            int[] lessArray = new int[less.size()];
            int[] greaterArray = new int[greater.size()];
            int j = 0;
            while (!less.isEmpty()) {
                lessArray[j++] = less.pop();
            }
            int k = 0;
            while (!greater.isEmpty()) {
                greaterArray[k++] = greater.pop();
            }

            int[] lessArrayResul = sort(lessArray);
            int[] greaterArrayResult = sort(greaterArray);
            int[] resul = new int[lessArrayResul.length + 1 + greaterArrayResult.length];
            System.arraycopy(lessArrayResul, 0, resul, 0, lessArrayResul.length);
            resul[lessArrayResul.length] = a[pivot];
            System.arraycopy(greaterArrayResult, 0, resul, lessArrayResul.length + 1, greaterArrayResult.length);
            return resul;
        }
    }

}
