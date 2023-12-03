package day61.LeetCode567;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //桶排序思想
        if (s1.length() > s2.length()) return false;
        if (s2.equals(s1)) return true;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt1[s1.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) return true;
        for (int i = s1.length(); i < s2.length(); i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) return true;
        }
        return false;
    }
}

