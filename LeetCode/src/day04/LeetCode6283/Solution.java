package day04.LeetCode6283;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,2,3};
        System.out.println(maximumCount(nums));

    }
    public static int maximumCount(int[] nums) {
        int p =0;
        int q =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0){
                p++;
            }
            if(nums[i]>0){
                q++;
            }
        }
        return Math.max(p,q);

    }
}
