package day82.LeetCode140;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 */
public class Solution {
    List<String> res = new LinkedList<>();
    LinkedList<String> list = new LinkedList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        backtracking(s, 0, wordDict);
        return res;
    }
    //回溯
    void backtracking(String s, int i, List<String> wordDict) {
        if (i == s.length()) {
            res.add(String.join(" ", list));
            return;
        }
        if (i > s.length()) {
            return;
        }
        for (String word : wordDict) {
            int len = word.length();
            if (i + len > s.length()) continue;
            String substring = s.substring(i, i + len);
            if (!substring.equals(word)) {
                continue;
            }
            list.add(word);
            backtracking(s, i + len, wordDict);
            list.removeLast();
        }


    }
}
