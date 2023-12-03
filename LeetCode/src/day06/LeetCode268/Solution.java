package day06.LeetCode268;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums ={0};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {

        Arrays.sort(nums);
       if(nums[nums.length-1]!=nums.length){
           return nums.length;
       }
        for (int i = 0; i < nums.length; i++) {
            if(i!=nums[i]){
                return i;
            }
        }
        return -1;

    }
}
