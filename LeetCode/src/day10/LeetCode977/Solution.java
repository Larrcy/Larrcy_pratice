package day10.LeetCode977;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(sortedSquares(nums));

    }

    public static int[] sortedSquares(int[] nums) {
        //对数组进行平方
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        //建立新数组并倒序存入数据
        //原数组非递减则平方后最大值一定在数组的前端或末端因此判断头尾即可
        int right = nums.length - 1;
        int[] ans = new int[nums.length];
        for (int p = 0, q = nums.length - 1; p <= q; ) {
            //若左边的数大于右边的数
            if (nums[p] > nums[q]) {
                //则将左边的数存入新数组
                ans[right] = nums[p];
                p++;
            } else {
                //若小于则存入右边的数
                ans[right] = nums[q];
                q--;

            }
            //新数组索引前移
            right--;


        }
        return ans;
    }
}
