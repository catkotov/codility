package org.cat.eye.algorithms.interview;

import java.util.logging.StreamHandler;

/**
 * Поиск элемента, который присутствует во всех трех неубывающих массивах.
 * Пример: даны три неубывающих массива {1,2,4,5}, {3,3,4} и {2,3,4,5,6},
 * результатом должен быть элемент 4.
 */
public class ElementSearchInArrays {

    public static int searchSameElement(int[] a, int[] b, int[] c) {

        int i = 0, j = 0, k = 0;

        int max = a[i];

        if (b[j] > max)
            max = b[j];
        if (c[k] > max)
            max = c[k];

        do {
            while (i < a.length && a[i] <= max) {
                if (a[i] >= max )
                    max = a[i];
                i++;
            }

            while (j < b.length && b[j] <= max) {
                if (b[j] >= max )
                    max = b[j];
                j++;
            }

            while (k < c.length && c[k] <= max) {
                if (c[k] >= max )
                    max = c[k];
                k++;
            }

        } while (a[i] != b[j] && b[j] != c[k]);

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
