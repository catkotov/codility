package org.cat.eye.leetcode;

/**
 * Given an integer array nums, find the subarray  with the largest sum, and return its sum.
 */
public class MaximumSubArray {

    public int maxSubArray(int[] num) {
        return findMaxSubArray(0, num.length - 1, num);
    }

    // работает не верно [-2,1,-3,4,-1,2,1,-5,4]
    //Output
    //7
    //Expected
    //6

    // [5,4,-1,7,8]
    //Output
    //17
    //Expected
    //23
    private int findMaxSubArray(int left, int right, int[] numArray) {
        if (left > right) {
            return Integer.MIN_VALUE;
        }

        int mid = Math.floorDiv(left + right, 2);
        int curr = 0;
        int bestLeftSum = 0;
        int bestRightSum = 0;

        for (int i = mid - 1; i >= left; i--) {
            curr += numArray[i];
            bestLeftSum = Math.max(curr, bestLeftSum);
        }

        curr = 0;
        for (int j = mid + 1; j <= right; j++) {
            curr += numArray[j];
            bestRightSum = Math.max(curr, bestRightSum);
        }

        int bestCurrSum = bestLeftSum + numArray[mid] + bestLeftSum;

        int leftHalf = findMaxSubArray(left, mid - 1, numArray);
        int rightHalf = findMaxSubArray(mid + 1, right, numArray);

        return Math.max(bestCurrSum, Math.max(leftHalf, rightHalf));
    }

    public int dynamicMaxSubArray(int [] num) {

        int currMaxSub = num[0];
        int maxSubArray = num[0];

        for (int i = 1; i < num.length; i++) {
            currMaxSub = Math.max(num[i], currMaxSub + num[i]);
            maxSubArray = Math.max(currMaxSub, maxSubArray);
        }

        return maxSubArray;
    }
}
