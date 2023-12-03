package day65.数位dp.LeetCode233;

import java.util.Arrays;

/**
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 */
class Solution {
    char s[];
    int dp[][];

    public int countDigitOne(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        dp = new int[m][m];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return f(0, 0, true);
    }

    int f(int i, int cnt1, boolean isLimit) {
        if (i == s.length) return cnt1;
        if (!isLimit && dp[i][cnt1] != -1) return dp[i][cnt1];
        int res = 0;
        for (int d = 0, up = isLimit ? s[i] - '0' : 9; d <= up; ++d) // 枚举要填入的数字 d
            res += f(i + 1, cnt1 + (d == 1 ? 1 : 0), isLimit && d == up);
        if (!isLimit) dp[i][cnt1] = res;
        return res;
    }

}