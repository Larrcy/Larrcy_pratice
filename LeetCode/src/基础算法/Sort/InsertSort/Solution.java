package 基础算法.Sort.InsertSort;

public class Solution {
    public void InsertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int insertVal = nums[i];
            int insertIndex = i - 1;//nums[i]前面的数的下标
            while (insertIndex >= 0 && insertVal < nums[insertIndex]) {
                nums[insertIndex + 1] = nums[insertIndex];
                insertIndex--;
            }
            nums[insertIndex+1]=insertVal;

        }


    }
}
