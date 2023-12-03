package day19.LeetCode435;

import java.util.Arrays;

public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        //将左边界从小到大排序
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        //统计区间个数
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            //若当前的左边界小于上一个的右边界则有重复部分则count++
            if(intervals[i][0]<intervals[i-1][1]){
                count++;
                //将两个中最小的右边界作为新的右边界
                intervals[i][1]=Math.min(intervals[i-1][1],intervals[i][1]);
            }
        }
        return count;

    }
}
