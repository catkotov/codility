package org.cat.eye.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] a = {"flower","flow","flight"};

        System.out.println(longestCommonPrefix(a));
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length < 2) {
            return strs[0];
        }

        String result = lcp(strs[0], strs[1]);

        for (int j = 2; j < strs.length; j++) {
            result = lcp(result, strs[j]);
        }

        return result;
    }

    public static String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        return lcp(strs[0], strs[strs.length - 1]);
    }

    private static String lcp(String s1, String s2) {
        int length, idx = 0;

        if (s1.length() < s2.length())
            length = s1.length();
        else
            length = s2.length();

        StringBuilder sb = new StringBuilder();

        while (idx < length && s1.charAt(idx) == s2.charAt(idx)) {
            sb.append(s1.charAt(idx));
            idx++;
        }

        return sb.toString();
    }

}
