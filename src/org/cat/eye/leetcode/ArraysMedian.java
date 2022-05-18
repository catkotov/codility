package org.cat.eye.leetcode;

public class ArraysMedian {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int z = m + n;

        int[] merge = new int[z];

        int i = 0;
        int j = 0;

        for (int k = 0; k < z; k++) {

            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    merge[k] = nums1[i];
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    merge[k] = nums2[j];
                    j++;
                } else {
                    merge[k] = nums1[i];
                    merge[++k] = nums2[j];
                    i++;
                    j++;
                }
            } else if (i < m) {
                merge[k] = nums1[i];
                i++;
            } else if (j < n) {
                merge[k] = nums2[j];
                j++;
            }
        }

        if (merge.length % 2 == 0) {

            int l = merge.length / 2;

            return (merge[l] + merge[l-1]) / (double) 2;

        } else {
            return merge[merge.length / 2];
        }
    }

    public static void main(String[] argv) {
        int[] n1 = {1, 3, 3, 3, 5};
        int[] n2 = {2, 3, 4, 7};

        ArraysMedian median = new ArraysMedian();

        System.out.println("result: " + median.findMedianSortedArrays(n1, n2));

    }

}
