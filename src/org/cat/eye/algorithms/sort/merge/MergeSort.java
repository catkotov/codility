package org.cat.eye.algorithms.sort.merge;

public class MergeSort {

    public static int[] mergeSort(int[] a) {

        return null;
    }

    public static void arraySegmentation(int[] tmp, int lowerBound, int upperBound) {
        if (lowerBound == upperBound)
            return;
        else {
            int middle = (lowerBound + upperBound) / 2;

            arraySegmentation(tmp, lowerBound, middle);

            arraySegmentation(tmp, middle + 1, upperBound);

            merge(tmp);
        }
    }

    public static int[] merge(int[] tmp) {

        return tmp;
    }

}
