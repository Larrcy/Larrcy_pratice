package day51.LeetCode41;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            //将所有的正数放到对应的下标上
            //即1 放到下标0上 2放到下标1上依次类推
            //用负数来填充缺失的那个正数
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                // 满足在指定范围内、并且没有放在正确的位置上，才交换
                // 例如：数值 3 应该放在索引 2 的位置上 即nums[i]应当在nums[nums[i]-1]的位置上
                swap(nums, nums[i] - 1, i);
            }
        }

        // [1, -1, 3, 4]
        //第一个负数对应的下标+1即为我们所缺少的第一个正数
        for (int i = 0; i < len; i++) {
            if (nums[i] -1!= i ) {
                return i+1 ;
            }
        }
        // 都正确则返回数组长度 + 1
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
