package day08.LeetCode283;

public class Solution {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
          moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                k++;
            } else {

                if (k > 0) {
                    //i-k即第一个0的位置
                    //交换第一个0和当前不为0的数的位置
                    nums[i - k] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
}
