package day36.Week309.LeetCode2400;

public class Solution {
    int MOD = (int) 1e9 + 7;
    int[][] memo;

    public int numberOfWays(int startPos, int endPos, int k) {
        /*
        记忆化DFS
        1 <= startPos, endPos, k <= 1000
        设向左的步数为l，向右的步数为r，走到终点等价于 r-l=endPos-startPos
        其中l+r=k && 0<=l<=k && 0<=r<=k && l与r均为整数
        可得知方程只有唯一解:l=(k+startPos-endPos)/2，r=(k+endPos-startPos)/2
        若有一个不是整数可以直接返回0，若都为整数通过记忆化dfs求解
        时间复杂度:O(k^2) 空间复杂度:O(k^2)
         */
        memo = new int[k + 1][k + 1];
        int ll = k + startPos - endPos, rr = k + endPos - startPos;
        // 先判断绝对不可能到达||不能凑成到达终点的情况
        if (endPos - startPos > k || ll % 2 == 1 || rr % 2 == 1) return 0;
        return dfs(ll / 2, rr / 2);
    }

    // 计算当向左移动次数为l，向右移动次数为r时的方案数(取余后)
    private int dfs(int l, int r) {
        if (memo[l][r] != 0) return memo[l][r];
        // base case -> 当某一边用完了，剩下的只有1种方案
        if (l == 0 || r == 0) return 1;
        // 当前的选择可以是向左或者向右
        int res = (dfs(l - 1, r) + dfs(l, r - 1)) % MOD;
        memo[l][r] = res;   // 记录
        return res;
    }
}
