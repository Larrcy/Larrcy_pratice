package day63.贪心.LeetCode1864;

/**
 * 贪心法
 * 给你一个二进制字符串 s ，现需要将其转化为一个 交替字符串 。请你计算并返回转化所需的 最小 字符交换次数，如果无法完成转化，返回 -1 。
 * <p>
 * 交替字符串 是指：相邻字符之间不存在相等情况的字符串。例如，字符串 "010" 和 "1010" 属于交替字符串，但 "0100" 不是。
 * <p>
 * 任意两个字符都可以进行交换，不必相邻 。
 */

class Solution {
    public int minSwaps(String s) {
        int one = 0;
        int zero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') one++;
            if (s.charAt(i) == '0') zero++;
        }
        if (Math.abs(one - zero) > 1) return -1;
        else if (s.length() % 2 == 0 && one != zero) return -1;
        else if (s.length() % 2 == 0) {
            return Math.min(swapTimes(s, 0) / 2, (s.length() - swapTimes(s, 0)) / 2);
        } else {
            if (one > zero) {
                return (s.length() - swapTimes(s, 0)) / 2;

            } else {
                return swapTimes(s, 0) / 2;
            }
        }
    }

    public int swapTimes(String s, int count1) {
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0 && s.charAt(i) == '1') {
                count1++;
            } else if (i % 2 != 0 && s.charAt(i) == '0') {
                count1++;
            }
        }
        return count1;
    }
}