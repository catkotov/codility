package org.cat.eye.leetcode;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        StringBuilder builder = new StringBuilder();

        s.chars().filter(Character::isLetterOrDigit)
                .mapToObj(ch -> Character.toLowerCase((char) ch))
                .forEach(builder::append);
        return builder.toString().contentEquals(builder.reverse().toString());
    }
}
