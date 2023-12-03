package LeetCode75_5.LeetCode162;

public class Solution {
    public int findPeakElement(int[] nums) {
        /*
        二分法
        注意相邻元素不同
         */
        int n = nums.length;
        if (n == 1) return 0;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l ) / 2;
            // 此处mid>0
            if (nums[mid] > nums[mid - 1]) {
                // nums[mid]>nums[mid - 1]
                l = mid+1;
            } else {
                // nums[mid]<nums[mid - 1]
                r = mid - 1;
            }
        }
        return l;
    }
}
