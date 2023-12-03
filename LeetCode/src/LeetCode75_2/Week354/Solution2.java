package LeetCode75_2.Week354;

import java.util.Arrays;

public class Solution2 {
    public int maximumBeauty(int[] nums, int k) {
        //滑动窗口思想
        //若最大值和最小值相差大于2k则无法变成相等的数
        Arrays.sort(nums);
        int left =0;
        int sum =0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]-nums[left]>2*k){
                left++;
            }
            sum=Math.max(sum,i-left+1);
        }
        return sum;
    }
}
