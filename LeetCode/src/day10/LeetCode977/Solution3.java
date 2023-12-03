package day10.LeetCode977;

public class Solution3 {
    //冒泡排序
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        BubbleSort(nums);
        return nums;

    }

    public void BubbleSort(int[] nums) {
        boolean flag = false;//标识变量 表示是否进行过交换 方便剪枝
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    swap(nums, j, j + 1);
                }
            }
            if (!flag) {//没发生过交换 直接跳出这趟的循环
                break;

            } else {
                flag = false;//重置flag 进行下次判断
            }
        }


    }


    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

}
