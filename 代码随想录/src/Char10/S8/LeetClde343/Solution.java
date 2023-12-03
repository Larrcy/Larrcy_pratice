package Char10.S8.LeetClde343;

public class Solution {
    public int integerBreak(int n) {
  //将数拆分成尽可能相等的数才能保证乘积最大
        //j*dp[i-j] 将i-j继续拆分

        //dp[i]含义：对i进行拆分所得的乘积最大值为dp[i]
        int []dp=new int[n+1];
        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <=i/2; j++) {
                dp[i]=Math.max(dp[i],Math.max(j*dp[i-j],j*(i-j)));
            }
        }
        return dp[n];

    }
}
