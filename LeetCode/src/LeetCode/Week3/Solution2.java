package LeetCode.Week3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        int[][]grid ={{6,28,37,34,12,30,43,35,6},{21,47,38,14,31,49,11,14,49},{6,12,35,17,17,2,45,27,43},{34,41,30,28,45,24,50,20,4}};
        System.out.println(differenceOfDistinctValues(grid));
    }
    public static int[][] differenceOfDistinctValues(int[][] grid) {
        int [][]res=grid.clone();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                Set<Integer> topLeft =new HashSet<>();
                Set<Integer>bottomRight =new HashSet<>();

                for (int p = i,q=j; q > 0&&p>0; p--,q--) {
                    topLeft.add(grid[p][q]);
                }
                for (int p = i+1,q=j+1; p< grid.length&&q < grid[i].length; p++,q++) {
                    bottomRight.add(grid[p][q]);
                }
                res[i][j]=Math.abs(topLeft.size()-bottomRight.size());
            }
        }
        return res;
    }
}
