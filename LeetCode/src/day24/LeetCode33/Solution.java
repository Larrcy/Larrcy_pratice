package day24.LeetCode33;

import javax.sound.midi.MidiChannel;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //数组分为两个部分后 一个一定是有序的另一个可能有序也可能是部分有序
            //对有序的部分二分查找
            //无序的部分再一分为2

            //前半部分有序
            if (nums[left] <= nums[mid]) {
                //target在left和mid之间 直接在左侧进行二分查找
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                //后半部分有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
