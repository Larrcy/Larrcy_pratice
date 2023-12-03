package day09.LeetCode459;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String s = "ababab";
        System.out.println(repeatedSubstringPattern(s));

    }

    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        String res = s + s;
        //将两个 s 连在一起，并移除第一个和最后一个字符，那么得到的字符串一定包含s，即 s 是它的一个子串
        return res.substring(1, n + n / 2).contains(s);
    }
}
