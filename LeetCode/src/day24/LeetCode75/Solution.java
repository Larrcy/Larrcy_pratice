package day24.LeetCode75;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums.length == 1) return;
        //把所有0放前面
        //把所有2放后面
        for (int p = nums.length - 2, q = nums.length - 1; p >= 0; ) {
            if (nums[p] == 0 && nums[q] == 0) {
                p--;
                continue;
            }
            if (nums[p] != 0 && nums[q] == 0) {
                swap(nums, p, q);
                p--;
                q--;
            } else {
                p--;
                q--;
            }
        }
        for (int p = 0, q = 1; q < nums.length; ) {
            if (nums[p] == 2 && nums[q] == 2) {
                q++;
                continue;
            }
            if (nums[p] == 2 && nums[q] != 2) {
                swap(nums, p, q);
                p++;
                q++;
            } else {
                p++;
                q++;
            }
        }

    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }

}
