package day33.LeetCode2089;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        quickSort(nums, 0, nums.length - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res.add(i);
            }
        }
        return res;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 找到基准值的位置，将数组分成两部分
            int pivotIndex = partition(arr, low, high);

            // 递归地对左边部分进行快速排序
            quickSort(arr, low, pivotIndex - 1);

            // 递归地对右边部分进行快速排序
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        // 选择基准值为数组最右边的元素
        int pivot = arr[high];

        // 定义左指针和右指针，用于找到基准值的位置
        int left = low;
        int right = high - 1;

        while (true) {
            // 从左边找到第一个比基准值大的元素
            while (left <= right && arr[left] <= pivot) {
                left++;
            }

            // 从右边找到第一个比基准值小的元素
            while (right >= left && arr[right] >= pivot) {
                right--;
            }

            // 如果左指针和右指针相遇，则退出循环
            if (left >= right) {
                break;
            }

            // 交换左右指针对应的元素，使得左边的元素都比基准值小，右边的元素都比基准值大
            swap(arr, left, right);
        }

        // 将基准值放到正确的位置，并返回基准值的位置
        swap(arr, left, high);
        return left;
    }


    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
