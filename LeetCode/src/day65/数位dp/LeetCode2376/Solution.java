package day65.数位dp.LeetCode2376;

import java.util.Arrays;

public class Solution {
    char[] s;
    int[][] dp;

    public int countSpecialNumbers(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        dp = new int[m][1 << 10];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    public int f(int i, int mask, boolean isLimited, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimited && isNum && dp[i][mask] != -1) {
            return dp[i][mask];
        }
        int ans = 0;
        if (!isNum) {
            ans = f(i + 1, mask, false, false);
        }
        int up = isLimited ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            if ((mask >> d & 1) == 0) {
                ans += f(i + 1, mask | (1 << d), isLimited && d == up, true);
            }
        }
        if (!isLimited && isNum) {
            dp[i][mask] = ans;
        }
        return ans;
    }
}
