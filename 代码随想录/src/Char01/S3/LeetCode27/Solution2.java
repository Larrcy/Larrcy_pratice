package Char01.S3.LeetCode27;

import java.util.Arrays;

public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int[] res = Arrays.stream(nums).distinct().toArray();
        if (nums == null || nums.length == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            }
        }
        for (int p = 0, q = 1; q < nums.length; ) {
            if (nums[p] == val && nums[q] != val) {
                swap(nums, p, q);
                p++;
                q++;
            } else if (nums[p] == val && nums[q] == val) {
                q++;
            } else {
                p++;
                q++;
            }
        }
        return nums.length - count;
    }

    public void swap(int[] nums, int p, int q) {
        int temp =  nums[p];
        nums[p] = nums[q];
        nums[q] = temp;

    }
}
