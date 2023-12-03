package day35.LeetCode2697;

import java.util.Arrays;

public class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] < chars[right]) {
                chars[right] = chars[left];
            }
            if (chars[right] < chars[left]) {
                chars[left] = chars[right];
            }
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
