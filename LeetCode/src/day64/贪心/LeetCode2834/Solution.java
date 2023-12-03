package day64.贪心.LeetCode2834;

/**
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 */

class Solution {
    public static void main(String[] args) {
        minimumPossibleSum(13,50);
    }
    static int mod =1000000007;
    public static int minimumPossibleSum(int n, int target) {
        if (n == 1) return 1;
        int t =target/2;
        int time = Math.min(n, t);
        return (int)  (((long) time *(time+1)/2)%mod+((2L *target+n-t-1)*(Math.max((n - t), 0))/2)%mod)%mod;
       /* for (int i = 1; i <= time; i++) {
            sum%=mod;
            sum += i;
        }*/

     /*   for (int i = 0; i < n - t; i++) {
            sum%=mod;
            sum += target;
            target++;
        }*/

    }
}