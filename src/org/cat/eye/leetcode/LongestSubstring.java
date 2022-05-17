package org.cat.eye.leetcode;

import java.util.*;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        if (s == null) return 0;

        int maxSubStr = 0;

        Set<Character> repeatCheck = new LinkedHashSet<>();
        Deque<Character> subStrQueue = new LinkedList<>();

        for (var ch : s.toCharArray()) {

            if (repeatCheck.contains(ch)) {
                Character tailCh = subStrQueue.pollFirst();
                while (tailCh != null && tailCh != ch) {
                    repeatCheck.remove(tailCh);
                    tailCh = subStrQueue.pollFirst();
                }
            }

            subStrQueue.add(ch);
            repeatCheck.add(ch);

            maxSubStr = Math.max(maxSubStr, subStrQueue.size());
        }

        return maxSubStr;
    }

    public int longestSubString_2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] argv) {

        LongestSubstring ss = new LongestSubstring();
        int result = ss.lengthOfLongestSubstring("tmmzuxt");

    }

}
