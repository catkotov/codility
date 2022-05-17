package org.cat.eye.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complementary = target - nums[i];

            if (numsMap.containsKey(complementary) && i != numsMap.get(complementary)) {
                int[] result = new int[2];
                result[1] = i;
                result[0] = numsMap.get(complementary);
                return result;
            } else {
                numsMap.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] argv) {

        int[] nums = {3, 2, 4};

        TwoSum t = new TwoSum();
        int[] result = t.twoSum(nums, 6);

    }

}
