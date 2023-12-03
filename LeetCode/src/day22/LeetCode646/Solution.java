package day22.LeetCode646;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findLongestChain(int[][] pairs) {
        //左边界 从小到大排序
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        //dp[i]第i个数对结尾的最大数对连长度
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j <pairs.length; j++) {
                if(pairs[j][1]<pairs[i][0]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp[pairs.length-1];
    }
}
