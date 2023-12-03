package LeetCode75_2.LeetCode1679;

import java.util.Arrays;

public class Solution {
    public int maxOperations(int[] nums, int k) {
        //先排序
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        //双指针操作
        while (left < right) {
            if (nums[left] + nums[right] == k) {
                left++;
                right--;
                count++;
                continue;
            }
          if(nums[left] + nums[right] >k){
              right--;
          }
          if(nums[left] + nums[right] <k){
              left++;
          }

        }
        return count;
    }
}

