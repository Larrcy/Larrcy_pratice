package Char01.S4.LeetCode977;

public class Solution {
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int right = nums.length - 1;
        int[] ans = new int[nums.length];
        //比较两头的值
        //因为存在负数 所以两头的数必有一个为最大值
        //左右指针依次遍历
        for (int p = 0, q = nums.length - 1; p <= q; ) {
            if (nums[p] > nums[q]) {
                ans[right] = nums[p];
                p++;
            } else {
                ans[right] = nums[q];
                q--;

            }
            right--;


        }
        return ans;
    }
}
