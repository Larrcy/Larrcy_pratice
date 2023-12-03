package day05.LeetCode217;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int [] nums ={1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));

    }

    public static boolean containsDuplicate(int[] nums) {
        int p = 0;
        int q = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[p]==nums[q]){
                return true;
            }else {
                p++;
                q++;
            }
        }
        return false;
    }
}
