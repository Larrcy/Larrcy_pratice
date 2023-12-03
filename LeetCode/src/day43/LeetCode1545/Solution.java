package day43.LeetCode1545;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(findKthBit(3, 5));
    }
    public static char findKthBit(int n, int k) {
        if(n==1)return '0';
        String[] s = new String[n];
        s[0] = "0";
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + "1" +invert(s[i-1]);
        }
        return s[n-1].charAt(k-1);

    }


    public static String invert(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') chars[i] = '1';
            else chars[i] = '0';
        }
        StringBuilder sb =new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb.reverse().toString();
    }
}

