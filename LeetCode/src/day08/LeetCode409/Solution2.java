package day08.LeetCode409;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) {
        String s = "bbbcccaa";
        System.out.println(longestPalindrome(s));

    }
    public static int longestPalindrome(String s) {
        // ASCII码字母常用范围在0-127
        int[] arr = new int[128];
        for(char c : s.toCharArray()) {
            //将字符存入整个数组 统计个数
            arr[c]++;
        }
        int count = 0;
        for (int i : arr) {
            //遍历集合统计奇数字符的个数
            count += (i % 2);
        }
        //若为偶数直接返回字符串长度
        //若为奇数则从count中只拿取一个即可组成中心对称
        return count == 0 ? s.length() : (s.length() - count + 1);
    }
}
