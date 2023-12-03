package day33.LeetCode628;

import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length - 1;
        quickSort(nums, 0, n);
        return Math.max(nums[n] * nums[n - 1] * nums[n - 2], nums[0] * nums[1] * nums[n]);
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int index = partition(nums, start, end);

            quickSort(nums, start, index - 1);
            quickSort(nums, index + 1, end);

        }

    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int pivotIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(nums, end, pivotIndex);
        return pivotIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
