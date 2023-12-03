package 基础算法.Sort.BubbleSort;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, -1, -5, 14, 77, 23, 66};
        BubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
    //冒泡排序
    public static void BubbleSort(int[] nums) {
        boolean flag = false;//标识变量 表示是否进行过交换 方便剪枝
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    swap(nums, j, j + 1);
                }
            }
            if (!flag) {//没发生过交换 则已排好直接跳出循环
                break;

            } else {
                flag = false;//重置flag 进行下次判断
            }
        }


    }


    public static void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

}
