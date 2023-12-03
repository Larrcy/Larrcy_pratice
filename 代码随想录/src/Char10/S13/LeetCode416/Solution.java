package Char10.S13.LeetCode416;

public class Solution {
    public boolean canPartition(int[] nums) {
        //0-1背包
        //有n件物品和一个最多能背重量为w 的背包。
        //第i件物品的重量是weight[i]，得到的价值是value[i] 。
        //每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大
        //0-1背包的递推公式为：dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int target = sum / 2;
        int dp[] = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                if (dp[i] == target) return true;
            }
        }
        return false;

    }

}
