package LeetCode75_2.LeetCode643;

import java.util.*;

public class Solution {
        public double findMaxAverage(int[] nums, int k) {
            int sum = 0;
            int n = nums.length;
            //0-k的和
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            int maxSum = sum;
            //从k的位置开始向后滑动
            for (int i = k; i < n; i++) {
                //减去起始的值 添加第k个位置的值
                sum = sum - nums[i - k] + nums[i];
                maxSum = Math.max(maxSum, sum);
            }
            return 1.0 * maxSum / k;
        }
    }


