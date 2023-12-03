package Offer6.S3;

public class Solution {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(i!=nums[i]){
                return i;
            }
        }
        return nums.length;
    }
}
