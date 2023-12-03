package day20.LeetCode189;

public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) return;
        while (k!=0) {
            for (int p = nums.length - 1, q = nums.length - 2; q >= 0; p--, q--) {
                swap(nums, p, q);
            }
        k--;
        }
    }

    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
