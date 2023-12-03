package day26.LeetCode1508;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        final int MODULO = 1000000007;
        //题目已给出sums的长度
        int sumsLength = n * (n + 1) / 2;
        int[] sums = new int[sumsLength];
        int index = 0;
        //计算子数组和
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                sums[index] = sum;
                index++;
            }
        }
        Arrays.sort(sums);
        int ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans = (ans + sums[i]) % MODULO;
        }
        return ans;
    }

}
