package cn.readsense.pattern.logic.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class LeetCode3 {


    public static void main(String args[]) {

    }


    /**
     * 暴力法，时间会超出
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

}
