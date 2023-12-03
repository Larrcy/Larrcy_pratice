package day23.LeetCode1351;

public class Solution {
    public int countNegatives(int[][] grid) {
        int count =0;
        for (int i = 0; i < grid.length; i++) {
            int left =0;
            int right =grid[i].length-1;
            while (left<=right){
                int mid =left +(right-left)/2;
                if(grid[i][mid]<0){

                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
            //遍历结束后 right会在第一个负数的左边位置 用length-right即为负数个数
            count +=grid[i].length-1-right;
        }
        return count;
    }
}
