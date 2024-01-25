package day89.LeetCode1255;

/**
 * 你将会得到一份单词表 words，一个字母表 letters （可能会有重复字母），以及每个字母对应的得分情况表 score。
 * <p>
 * 请你帮忙计算玩家在单词拼写游戏中所能获得的「最高得分」：能够由 letters 里的字母拼写出的 任意 属于 words 单词子集中，分数最高的单词集合的得分。
 * <p>
 * 单词拼写游戏的规则概述如下：
 * <p>
 * 玩家需要用字母表 letters 里的字母来拼写单词表 words 中的单词。
 * 可以只使用字母表 letters 中的部分字母，但是每个字母最多被使用一次。
 * 单词表 words 中每个单词只能计分（使用）一次。
 * 根据字母得分情况表score，字母 'a', 'b', 'c', ... , 'z' 对应的得分分别为 score[0], score[1], ..., score[25]。
 * 本场游戏的「得分」是指：玩家所拼写出的单词集合里包含的所有字母的得分之和。
 */
public class Solution {
    //子集型回溯
    private int res = 0;
    private int len;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        len = words.length;
        int[] m = new int[26];
        for (char x : letters) {
            ++m[x - 'a'];
        }
        dfs(words, m, score, 0, 0);
        return res;
    }

    private void dfs(String[] words, int[] m, int[] score, int start, int temp) {
        res = Math.max(res, temp);
        for (int i = start; i < len; ++i) {
            int j = 0, l = words[i].length();
            for (; j < l; ++j) {
                if (m[words[i].charAt(j) - 'a'] <= 0) break;
                --m[words[i].charAt(j) - 'a'];
                temp += score[words[i].charAt(j) - 'a'];
            }
            //当前字符串能够被组成则继续匹配下个字符串
            if (j == l) {
                dfs(words, m, score, i + 1, temp);
            }
            //若不能组成则进行回溯操作
            for (--j; j >= 0; --j) {
                ++m[words[i].charAt(j) - 'a'];
                temp -= score[words[i].charAt(j) - 'a'];
            }
        }
    }


}
