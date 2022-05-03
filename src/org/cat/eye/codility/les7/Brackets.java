package org.cat.eye.codility.les7;

/*
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

 - S is empty;
 - S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
 - S has the form "VW" where V and W are properly nested strings.

For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0,
as explained above.

Write an efficient algorithm for the following assumptions:

 - N is an integer within the range [0..200,000];
 - string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".

 */

import java.util.*;

public class Brackets {

    private static final Set<Character> openBrackets = new HashSet<>(List.of('(', '{', '['));
    private static final Map<Character, Character> brackets = new HashMap<>();
    static {
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
    }

    public int solution(String S) {

        int result = 1;

        if (S.isEmpty())
            return 1;

        Deque<Character> stack = new LinkedList<>();

        for (char ch : S.toCharArray()) {
            if (openBrackets.contains(ch)) {
                stack.push(ch);
            } else if (brackets.containsKey(ch)) {
                Character closeBracket = stack.pollFirst();
                if (null == closeBracket)
                    return 0;
                else if (!brackets.get(ch).equals(closeBracket))
                    return 0;
            }
        }

        if (!stack.isEmpty())
            return 0;

        return result;
    }

    public static void main(String[] argv) {

        Brackets b = new Brackets();

        String S = "{[()()]}";
        String S1 = "([)()]";

        System.out.println("result S: " + b.solution(S));
        System.out.println("result S1: " + b.solution(S1));
    }

}
