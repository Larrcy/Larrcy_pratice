package day18.LeetCode452;

import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length==0)return 0;
        //根据气球的左边界进行从小到大排序
        Arrays.sort(points, (a, b) -> {
            Integer.compare(a[0], b[0]);
            return b[0] - a[0];
        });
        //记录剑的数量
        int count =1;
        for (int i = 1; i < points.length; i++) {
            //第i个气球与第i-1个气球无公共区域则剑支数量+1
            if(points[i][0]>points[i-1][1]){
                count++;
            }else {
                //若有公共区域则以右边界小的那个作为新的右边界
                points[i][1]=Math.min(points[i-1][1],points[i][1]);
            }
        }
        return count;
    }

}
