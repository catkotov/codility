package org.cat.eye.algorithms.interview;

import java.util.logging.StreamHandler;

/**
 * Даны три неубывающих массива чисел. Найти число, которое присутствует во всех трех массивах.
 * Input: [1,2,4,5], [3,3,4], [2,3,4,5,6]
 * Output: 4
 * Целевое решение работает за O(p + q + r), где p, q, r – длины массивов, доп. память O(1), но эту информацию интервьюер не сообщает.
 */
public class ElementSearchInArrays {

    public static int searchSameElement(int[] a, int[] b, int[] c) {

        int i = 0, j = 0, k = 0;

        int max = a[i];

        if (b[j] > max)
            max = b[j];
        if (c[k] > max)
            max = c[k];

        boolean flag;

        do {

            flag = false;

            while (i < a.length && a[i] < max) {

                i++;
                flag = true;

                if (a[i] >= max ) {
                    max = a[i];
                }
            }

            while (j < b.length && b[j] < max) {

                j++;
                flag = true;

                if (b[j] >= max ) {
                    max = b[j];
                }
            }

            while (k < c.length && c[k] < max) {

                k++;
                flag = true;

                if (c[k] >= max ) {
                    max = c[k];
                }
            }

        } while (flag);

        System.out.println("a = " + a[i] + ", b = " + b[j] + ", c = " + c[k]);

        return a[i];
    }

    public static void main(String[] argv) {

        int[] a = {1, 2, 4, 5};
        int[] b = {3, 3, 5};
        int[] c = {2, 3, 4, 5, 6};

        ElementSearchInArrays.searchSameElement(a, b, c);
    }

}
