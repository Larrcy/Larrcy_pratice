package day65.数位dp.LeetCode902;

import java.util.Arrays;

/**
 * 给定一个正整数 n ，请你统计在 [0, n] 范围的非负整数中，有多少个整数的二进制表示中不存在 连续的 1 。
 */
class Solution {
    char[] c;
    int[][] dp;
    public int findIntegers(int n) {
        c = Integer.toBinaryString(n).toCharArray();
        //二进制只填0 1
        dp = new int[c.length][1<<1];
        for(int i = 0; i < c.length; i++) Arrays.fill(dp[i],-1);
        return dfs(0,0,true);
    }
    //一开始上一个二进制数补0
    int dfs(int i,int last,boolean isLimit) {
        if(i == c.length) return 1;
        if(!isLimit && dp[i][last] != -1) return dp[i][last];
        int res = 0;
        int max = isLimit ? c[i] - '0' : 1;//二进制最大为1
        for(int j = 0;j <= max; j++) {
            //不连续1即连续两个数和<=1
            if(last + j <= 1) res += dfs(i + 1,j,isLimit && j == max);
        }
        if(!isLimit) dp[i][last] = res;
        return res;
    }

}
