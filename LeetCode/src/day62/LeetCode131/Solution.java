package day62.LeetCode131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
class Solution {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
    if(startIndex==s.length()){
        res.add(new ArrayList<>(path));
    }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                //则将字符串收集起来添加进集合
                String str = s.substring(startIndex, i + 1);
                path.add(str);
            } else {
                continue;
            }
            //进行递归操作
            backtracking(s, i + 1);
            //回溯
            path.removeLast();
        }
    }
    private  boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


}