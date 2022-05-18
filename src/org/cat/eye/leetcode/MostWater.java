package org.cat.eye.leetcode;

public class MostWater {
    public int maxArea(int[] height) {

        int result = 0;
        int begin = 0;
        int end = height.length - 1;

        do {
            int l = end - begin;
            int h = Math.min(height[begin], height[end]);

            result = Math.max(l * h, result);

            if (height[begin] < height[end]) {
                begin++;
            } else if (height[begin] > height[end]) {
                end--;
            } else {
                begin++;
                end--;
            }

        } while (end >= begin);

        return result;
    }
}
