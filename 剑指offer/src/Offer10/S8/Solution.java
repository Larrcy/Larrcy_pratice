package Offer10.S8;

public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true; //此时都为空，可以匹配
        for (int j = 2; j < n; j += 2)
            //当s为空时，p必须满足a*b*.*这样的结构才能匹配成空串
            //当s不为空，p为空为false
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //判断p的第j位是不是*，是*则判断前一位与i是否相等，相等则可以匹配0次或者多次
                if (p.charAt(j - 1) == '*') {
                    //此时i和j的前一位可以直接匹配,若匹配0次，j还要向前看一位j-2看是否匹配，如a和aa*匹配
                    //若匹配多次，j不变，i向前看一位，若i-1位匹配0次，则说明i匹配一次，若
                    //i-1匹配1次，则i匹配两次，所以j的位置保持不动，缩小i向前匹配即可，如 aaa和a*
                    //j-1是*时j不可能在首位，j-2不会越界
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    } else {
                        //若前一位不能匹配只能匹配0次，j再向前看一位能否匹配,如aab和aaba*
                        //可以和上面的情况整合一下
                        dp[i][j] = dp[i][j - 2];
                    }
                } else {//不是'*'，则只需要看上一位i和上一位j是否匹配,如aab和aa.
                    dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));
                }
            }
        }
        return dp[m - 1][n - 1];
    }

}
