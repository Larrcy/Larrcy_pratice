package Char09.S20.LeetCode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 1)
            return intervals;
        //左边界排序
        Arrays.sort(intervals, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        //从1开始遍历 将下标为0的数组先放入集合
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            //用放入结果集的数组边界来进行下一步的判断
            if (intervals[i][0] <= res.get(res.size()-1)[1]) {
                int  left = res.get(res.size()-1)[0];
                int right = Math.max(intervals[i][1], res.get(res.size()-1)[1]);
               //移除集合中最后一个元素再将新的集合添加进去
                res.remove(res.size()-1);
                res.add(new int[]{left,right});
            } else {
                res.add(intervals[i]);

            }
        }
        //集合转换为数组
        return res.toArray(new int[0][]);
    }
}
