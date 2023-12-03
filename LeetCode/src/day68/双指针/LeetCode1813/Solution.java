package day68.双指针.LeetCode1813;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 *一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，"Hello World" ，"HELLO" ，"hello world hello world" 都是句子。每个单词都 只 包含大写和小写英文字母。
 *
 * 如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，那么我们称这两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。
 *
 * 给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false
 */
public class Solution {
    //插入的句子必然是中间的句子
    // 先用空格分割所有的单词，然后统计左边相等单词的数量，再统计右边相等单词的数量
    // 若两个数量之和等于最小单词数，
    // 那么代表可以往这个单词中间添加一些单词使得两个字符串相等。

    public boolean areSentencesSimilar(String s1, String s2) {
        if (s1.length() > s2.length()) return areSentencesSimilar(s2, s1);
        String[] arr1 = s1.split(" "), arr2 = s2.split(" ");
        int n = arr1.length, m = arr2.length, l = 0, r = 0;
        while (l < n && arr1[l].equals(arr2[l])) l++;
        while (r < n - l && arr1[n - r - 1].equals(arr2[m - r - 1])) r++;
        return l + r == n;
    }

}
