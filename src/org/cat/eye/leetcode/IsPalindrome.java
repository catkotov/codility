package org.cat.eye.leetcode;

public class IsPalindrome {

    public boolean isPalindrome(int x) {

        char[] intChars = Integer.toString(x).toCharArray();

        for (int i = 0; i < intChars.length / 2; i++) {
            if (intChars[i] != intChars[intChars.length - i - 1]) {
                return false;
            }
        }

        return true;
    }

}
