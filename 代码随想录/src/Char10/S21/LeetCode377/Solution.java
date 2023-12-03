package Char10.S21.LeetCode377;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
    int[]dp =new int[target+1];
    dp[0]=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= target; j++) {
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
