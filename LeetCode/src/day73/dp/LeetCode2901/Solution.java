package day73.dp.LeetCode2901;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * dp 类比300题
 * 给你一个整数 n 和一个下标从 0 开始的字符串数组 words ，和一个下标从 0 开始的数组 groups ，两个数组长度都是 n 。
 *
 * 两个长度相等字符串的 汉明距离 定义为对应位置字符 不同 的数目。
 *
 * 你需要从下标 [0, 1, ..., n - 1] 中选出一个 最长子序列 ，将这个子序列记作长度为 k 的 [i0, i1, ..., ik - 1] ，它需要满足以下条件：
 *
 * 相邻 下标对应的 groups 值 不同。即，对于所有满足 0 < j + 1 < k 的 j 都有 groups[ij] != groups[ij + 1] 。
 * 对于所有 0 < j + 1 < k 的下标 j ，都满足 words[ij] 和 words[ij + 1] 的长度 相等 ，且两个字符串之间的 汉明距离 为 1 。
 * 请你返回一个字符串数组，它是下标子序列 依次 对应 words 数组中的字符串连接形成的字符串数组。如果有多个答案，返回任意一个。
 *
 * 子序列 指的是从原数组中删掉一些（也可能一个也不删掉）元素，剩余元素不改变相对位置得到的新的数组。
 *
 * 注意：words 中的字符串长度可能 不相等
 */
public class Solution {
    //定义f[i] 表示从 i 到 n−1中，我们选出的最长子序列的长度
    //如果 groups[j]≠groups[i]且 words[j]和 words[i] 满足题目要求，
    //并且 f[j]+1>f[i]，那么更新f[i]=f[j]+1
    //并且记录转移来源from[i]=j。
    //那么最长子序列的长度就是max(f)。
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        int[] f = new int[n];  // 用于存储以每个单词结尾的最长子序列的长度
        int[] g = new int[n];  // 用于存储每个位置的最长子序列的前一个位置
        int mx = 0;
        for (int i = 0; i < n; i++) {
            f[i]=1;
            //枚举倒数第二个数
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && ok(words[i], words[j])) {
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                        //存储满足条件的下标
                        g[i] = j;
                    }
                }
            }
            //当以i结尾的长度比以mx结尾的长度更大时则更新mx
            if (f[i] > f[mx]) mx = i;
        }


        int m = f[mx];  // 最长子序列的长度
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            ans.add(words[mx]);  // 将每个位置的单词添加到结果列表中
            mx = g[mx];  // 移动到前一个位置
        }
        Collections.reverse(ans);
        return ans;  // 返回结果列表
    }

    private static boolean ok(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        boolean diff = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (diff) return false;
                diff = true;
            }
        }
        return diff;
    }


}
