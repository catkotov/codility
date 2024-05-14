package org.cat.eye.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class ValidParentheses {
    private static final HashMap<Character, Character> parentheses = new HashMap<>();
    static {
        parentheses.put(']', '[');
        parentheses.put('}', '{');
        parentheses.put(')','(');
    }

    public static boolean isValid(String s) {

        Deque<Character> stack = new LinkedList<>();

        for (Character cr : s.toCharArray()) {
           if (!parentheses.containsKey(cr)) {
               stack.push(cr);
           } else if (stack.isEmpty() || !parentheses.get(cr).equals(stack.pop()))
               return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

}
