package day64.贪心.LeetCode435;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int res = 0;
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            //若当前数组的左边界小于上个数组的有边界
            //则说明有重叠部分
            //新的有边界取两个数组最小的右边界
            if (intervals[i][0] < right) {
                res++;
                right = Math.min(right, intervals[i][1]);

            } else {
                //若不重叠 则当前数组的有边界为新的右边界
                right = intervals[i][1];
            }
        }
        return res;
    }
}
