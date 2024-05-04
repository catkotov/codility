package org.cat.eye.algorithms.sort.merge;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {3,1,2,9,8,4,7,5,0,6};
        System.out.println("source = " + Arrays.toString(a));
        int[] result = mergeSort(a);
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] mergeSort(int[] a) {
        int[] tmp = new int[a.length];
        return arraySegmentation(a, tmp, 0, a.length - 1);
    }

    public static int[] arraySegmentation(int[]source, int[] tmp, int lowerBound, int upperBound) {
        if (lowerBound == upperBound)
            return tmp;
        else {
            int middle = (lowerBound + upperBound) / 2;

            arraySegmentation(source, tmp, lowerBound, middle);

            arraySegmentation(source, tmp, middle + 1, upperBound);

            merge(source, tmp, lowerBound, middle + 1, upperBound);

            return tmp;
        }
    }

    public static void merge(int[] source, int[] tmp, int lowerBound, int middleBound, int upperBound) {

        int i = 0;
        int mid = middleBound;
        int lower = lowerBound;

        while (lower <= middleBound - 1 && mid <= upperBound) {
            if (source[lower] <= source[mid]) {
                tmp[i++] = source[lower++];
            } else  {
                tmp[i++] = source[mid++];
            }
        }

        while (lower <= middleBound - 1) {
            tmp[i++] = source[lower++];
        }
        while (mid <= upperBound) {
            tmp[i++] = source[mid++];
        }

        for (int j = lowerBound, k = 0; j <= upperBound; j++, k++) {
            source[j] = tmp[k];
        }
    }

}
