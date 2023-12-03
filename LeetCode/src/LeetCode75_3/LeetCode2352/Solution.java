package LeetCode75_3.LeetCode2352;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int equalPairs(int[][] grid) {
        List<List<Integer>>res1 =new ArrayList<>();
        List<List<Integer>>res2 =new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer>list =new ArrayList<>();
            for (int j = 0; j < grid.length; j++) {
                list.add(grid[i][j]);
            }
            res1.add(list);
        }
        for (int i = 0; i < grid.length; i++) {
            List<Integer>list =new ArrayList<>();
            for (int j = 0; j < grid.length; j++) {
                list.add(grid[j][i]);
            }
            res2.add(list);
        }
        int count =0;
        for (int i = 0; i < res1.size(); i++) {
            for (int j = 0; j < res2.size(); j++) {
                if(res1.get(i).equals(res2.get(j))){
                    count++;
                }
            }
        }
        return count;
    }
}
