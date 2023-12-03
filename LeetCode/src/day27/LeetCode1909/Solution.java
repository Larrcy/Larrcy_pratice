package day27.LeetCode1909;

import java.util.Stack;

public class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int flag=0;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]<=nums[i-1]){
                if(flag!=0) return false; //flag!=0说明之前已经存在非递增位置,直接false
                if(i+1<nums.length){
                    if(nums[i+1]>nums[i-1]||i>=2&&nums[i]>nums[i-2]||i==1){ //按上述情况所述进行判断
                        flag=1;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
