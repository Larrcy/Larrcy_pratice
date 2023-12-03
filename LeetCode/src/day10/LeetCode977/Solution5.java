package day10.LeetCode977;

public class Solution5 {

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        InsertSort(nums);
        return nums;

    }

    //插入排序
    public void InsertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int insertVal = nums[i];
            int insertIndex = i - 1;//nums[i]前面的数的下标
            //循环判断当前的数是否比左区间内最右侧的数小
            //如果小则将左区间的数向右移动
            while (insertIndex >= 0 && insertVal < nums[insertIndex]) {
                nums[insertIndex + 1] = nums[insertIndex];
                insertIndex--;
            }
            nums[insertIndex + 1] = insertVal;

        }
    }
}
