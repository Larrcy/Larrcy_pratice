package day85.LeetCode2767;

import java.util.*;

/**
 * 给你一个二进制字符串 s ，你需要将字符串分割成一个或者多个 子字符串  ，使每个子字符串都是 美丽 的。
 * <p>
 * 如果一个字符串满足以下条件，我们称它是 美丽 的：
 * <p>
 * 它不包含前导 0 。
 * 它是 5 的幂的 二进制 表示。
 * 请你返回分割后的子字符串的 最少 数目。如果无法将字符串 s 分割成美丽子字符串，请你返回 -1 。
 * <p>
 * 子字符串是一个字符串中一段连续的字符序列。
 */
public class Solution {
    int[] cache;

    public int minimumBeautifulSubstrings(String s) {
        //题目要求s的长度最大为15 因此预处理 2^15以内的 5 的幂（有 7 个）。
        int n = s.length();
        Set<String> set = new HashSet<>();
        cache = new int[n + 1];
        for (int i = 0; i < 8; i++) {
            set.add(Integer.toBinaryString((int) Math.pow(5, i)));
        }
        int res = dfs(n, s, set);
        return res == Integer.MAX_VALUE - 1 ? -1 : res;
    }

    public int dfs(int i, String s, Set<String> set) {
        //从后往前分割 若到达下标0说明分割完成
        if (i == 0) return 0;
        if (cache[i] > 0) return cache[i];
        int res = Integer.MAX_VALUE - 1;
        for (int j = i - 1; j >= 0; j--) {
            if (s.charAt(j) != '0' && set.contains(s.substring(j, i))) {
                //递归要加1 会导致溢出因此res初始化成Inf-1
                res = Math.min(res, dfs(j, s, set) + 1);
            }
        }

        return cache[i] = res;
    }
}
