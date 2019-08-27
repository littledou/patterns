package cn.readsense.pattern.logic.leetcode;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class LeetCode3 {


    public static void main(String args[]) {
        lengthOfLongestSubstring1("abcabcbb");
    }


    /**
     * 暴力法，时间会超出
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        if (s == null || s.equals("")) return 0;
        Set set = new HashSet();

        for (int i = s.length(); i > 0; i--) {

            for (int j = 0; j < s.length(); j++) {
                if (j + i <= s.length()) {
                    set.clear();
                    final String substring = s.substring(j, i);

                    for (int k = 0; k < i; k++) {
                        set.add(substring.charAt(k));
                        if (set.size() != k + 1) break;
                    }
                    if (set.size() == i) return i;
                }
            }

        }

        return longest;
    }

    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new LinkedHashSet<>();

        final char[] chars = s.toCharArray();

        int targetPosition = 0;
        int nextLength;
        int maxLength = 0;
        for (int i = 0; i < chars.length; i++) {

            nextLength = set.size() + 1;
            final char aChar = chars[i];
            set.add(aChar);

            while (set.size() != nextLength) {
                set.remove(chars[targetPosition]);
                targetPosition++;
                nextLength = set.size() + 1;
                set.add(aChar);
            }
            if (maxLength < nextLength) maxLength = nextLength;

        }
        return maxLength;

    }

}
