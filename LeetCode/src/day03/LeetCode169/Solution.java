package day03.LeetCode169;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums ={2,2,2,1,1};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //双指针
        int p = 0;
        int q = 1;
        int count=1;
        Arrays.sort(nums);
        //直接返回排序后的中间值一定是超过半数的
        // return nums[nums.length / 2];
        for (int i = 0; i < nums.length; i++) {
            //若出现相等的情况则count+1
            if(nums[p]==nums[q]){
                p++;
                q++;
                count++;
            }//当出现不相等且不超过半数时 则计数器归1 重新计算
            else if(nums[p]!=nums[q]&&count<=nums.length/2){
                p++;
                q++;
                count=1;
            }
            //只要计数器超过半数直接返回p指针所指的位置
            if(count>nums.length/2){
                return nums[p];
            }
        }
        return 0;
    }

}
