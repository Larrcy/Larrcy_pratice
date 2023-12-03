package day51.LeetCode556;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //排序后收集集合
        List<int[]> res =new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            //若遍历到的左边界小于当前集合的右边界
            //则区间可以合并
            if(intervals[i][0]<=res.get(res.size()-1)[1]){
                int left =res.get(res.size()-1)[0];
                int right=Math.max(intervals[i][1],res.get(res.size()-1)[1]);
                //将原来的集合删除 添加进去合并后的集合
                res.remove(res.size()-1);
                res.add(new int[]{left,right});
            }else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[0][]);
    }
}
