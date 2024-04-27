package org.cat.eye.algorithms.interview;

/**
 * Даны три неубывающих массива чисел. Найти число, которое присутствует во всех трех массивах.
 * Input: [1,2,4,5], [3,3,4], [2,3,4,5,6]
 * Output: 4
 * Целевое решение работает за O(p + q + r), где p, q, r – длины массивов, доп. память O(1), но эту информацию интервьюер не сообщает.
 */
public class ElementSearchInArrays {

    public static int searchSameElement(int[] a, int[] b, int[] c) throws Exception {

        int i = 0, j = 0, k = 0;

        int max = a[i];

        if (b[0] > max)
            max = b[0];
        if (c[0] > max)
            max = c[0];

        boolean flag;

        do {

            flag = false;

            while (i < a.length - 1 && a[i] < max) {
                i++;
                flag = true;
                if (a[i] >= max ) {
                    max = a[i];
                }
            }

            while (j < b.length - 1 && b[j] < max) {
                j++;
                flag = true;
                if (b[j] >= max ) {
                    max = b[j];
                }
            }

            while (k < c.length - 1 && c[k] < max) {
                k++;
                flag = true;
                if (c[k] >= max ) {
                    max = c[k];
                }
            }

        } while (flag);

        if (a[i] == b[j] && b[j] == c[k])
            return a[i];
        else
            throw new Exception("В массивах нет одинаковых элементов");
    }

    public static void main(String[] argv) {

        int[] a = {1, 2, 4, 7};
        int[] b = {3, 3, 4};
        int[] c = {2, 3, 4, 5, 6};

        try {
            System.out.println(ElementSearchInArrays.searchSameElement(a, b, c));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
