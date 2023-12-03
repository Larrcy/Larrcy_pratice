package day18.LeetCode452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    public int findMinArrowShots(int[][] points) {
    //对左边界从小到大排序
        Arrays.sort(points, Comparator.comparingInt(a->a[0]));
        //dp[i]以points[i]结尾的数组的不重叠的数量
        int[]dp =new int[points.length];
        Arrays.fill(dp,1);
        for (int i = 1; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if(points[i][0] >points[j][1]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp[points.length-1];
    }
}
