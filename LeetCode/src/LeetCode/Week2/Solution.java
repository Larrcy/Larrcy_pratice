package LeetCode.Week2;

public class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int nums[] = new int[n];
        int res[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            nums[queries[i][0]] = queries[i][1];
            int count =0;
            for (int p = 0,q=1; q < nums.length; p++,q++) {
                if(nums[p]==nums[q]&&nums[p]!=0&&nums[q]!=0){
                    count++;
                }
            }
            res[i]=count;

        }
        return res;

    }
}
