package day81.LeetCode2963;

import java.util.HashMap;

/**
 * 给你一个下标从 0 开始、由 正整数 组成的数组 nums。
 *
 * 将数组分割成一个或多个 连续 子数组，如果不存在包含了相同数字的两个子数组，则认为是一种 好分割方案 。
 *
 * 返回 nums 的 好分割方案 的 数目。
 *
 * 由于答案可能很大，请返回答案对 109 + 7 取余 的结果。
 */
public class Solution {
    public int numberOfGoodPartitions(int[] nums) {
        HashMap<Integer, Integer> r = new HashMap<>();
        //r存放最后一次出现该数字的下标
        for (int i = 0; i < nums.length; i++) {
            r.put(nums[i], i);
        }
        //记录区间个数
        int ans = 0;
        //记录区间的右端点的最大值
        int max_r = 0;
        for (int i = 0; i < nums.length ; i++) {
            //更新右端点的最大值
            max_r = Math.max(max_r, r.get(nums[i]));
            // 区间无法延长则说明走到了区间的尽头
            //将当前区间合并
            if (max_r == i) {
               ans++;
            }
        }
        return pow_mod( 2, ans-1,  (int)1e9+7);
    }
    int pow_mod(long a, int b, int mod) {
        long res = 1;
        while (b != 0) {
            if (b % 2 == 1) res = (res * a) % mod;
            b >>= 1;
            a = (a * a) % mod;
        }
        return (int)res;
    }

}
