package day09.LeetCode392;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        //双指针
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        //贪心算法 只要能匹配到就进行下一个字符的匹配
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        //长度相等即相等
        return i == n;
    }
}


