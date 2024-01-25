package day86.LeetCode2719;

import java.util.Arrays;

/**
 * 给你两个数字字符串 num1 和 num2 ，以及两个整数 max_sum 和 min_sum 。如果一个整数 x 满足以下条件，我们称它是一个好整数：
 * <p>
 * num1 <= x <= num2
 * min_sum <= digit_sum(x) <= max_sum.
 * 请你返回好整数的数目。答案可能很大，请返回答案对 109 + 7 取余后的结果。
 * <p>
 * 注意，digit_sum(x) 表示 x 各位数字之和。
 */
public class Solution {
    char[] chars; // 把给定的整数n转化为字符串数组
    int[][] dp;
    private static final int MOD = 1_000_000_007;
    //把问题拆分成：
    //计算≤num2的好整数个数，记作 a。
    //计算1≤num1-1的好整数个数，记作 b。
    //那么答案就是 a−b
    //考虑到 num1是个字符串，不方便减一，可以改为计算 ≤num1的合法数字个数，
    //再单独判断 num1 这个数是否合法。

    public int count(String num1, String num2, int minSum, int maxSum) {
        int ans = findIntegers(num2, minSum, maxSum) - findIntegers(num1, minSum, maxSum) + MOD; // 避免负数
        //特殊判断num1是否合法
        int sum = 0;
        for (char c : num1.toCharArray()) {
            sum += c - '0';
        }
        if (minSum <= sum && sum <= maxSum) {
            ans++; // num1 是合法的，补回来
        }
        return ans % MOD;

    }

    public int findIntegers(String s, int minSum, int maxSum) {
        // 把给定的整数n转化为字符串数组
        chars = s.toCharArray();
        int m = s.length();
        //初始化dp 默认初始化成 10*m
        dp = new int[m][10 * m];
        // 初始化dp
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1); // -1表示没有计算过
        return f(0, 0, true, minSum, maxSum);
    }

    //前导0对数位和没有影响 可以不用isNum
    public int f(int i, int sum, boolean isLimit, int minSum, int maxSum) {
        //非法情况
        if (sum > maxSum) return 0;
        if (i == chars.length)
            //到达结尾时判断该数字是否合法
            return sum >= minSum ? 1 : 0;

        //固定格式记忆化
        if (!isLimit && dp[i][sum] != -1)
            return dp[i][sum];

        int ans = 0;

        //二进制 int up = isLimit ? s[i] - '0' : 1;
        //十进制 int up = isLimit ? s[i] - '0' : 9;
        int up = isLimit ? chars[i] - '0' : 9;
        //固定格式
        for (int d = 0; d <= up; d++) {
            //判断条件根据题目条件变化
            ans = (ans+f(i + 1, d + sum, isLimit && (d == up), minSum, maxSum))%MOD;
        }
        //前面填了数且前面填的数不受限制
        //更新dp[i]
        if (!isLimit)
            dp[i][sum] = ans;
        return ans;
    }

}
