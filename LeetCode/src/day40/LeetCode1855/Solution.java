package day40.LeetCode1855;

public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0;
        for (int j = 0; j < nums2.length; j++) {
            int left = 0;
            int right = Math.min(j, nums1.length - 1);
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums1[mid] > nums2[j]) {
                    left = mid + 1;
                }
                if (nums1[mid] <= nums2[j]) {
                    right = mid - 1;
                }
            }
            if (left == nums1.length) left = j;
            res = Math.max(res, j - left);

        }
        return res;
    }
}
