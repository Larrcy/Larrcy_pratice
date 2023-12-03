package day16.LeetCide131;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));

    }

    public static List<List<String>> res = new ArrayList<>();
    public static LinkedList<String> path = new LinkedList<>();

    public static List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    public static void backtracking(String s, int startIndex) {
        //startIndex为分割点当分割点到最后时收集结果
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < s.length(); i++) {
            //若回文
            if (isPalindrome(s, startIndex, i)) {
                //则将字符串收集起来添加进集合
                String str = s.substring(startIndex, i + 1);
                path.addLast(str);
            } else {
                continue;
            }
            //进行递归操作
            backtracking(s, i + 1);
            //回溯
            path.removeLast();
        }

    }

    //判断字符串是否回文
    private static boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}

