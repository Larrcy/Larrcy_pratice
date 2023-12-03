package LeetCode.Week1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[]nums ={3,2,3,4,2};
        System.out.println(distinctDifferenceArray(nums));
    }
    public static int[] distinctDifferenceArray(int[] nums) {
        int[] res =new int[nums.length];


        for (int i = 0; i < res.length; i++) {
            Set<Integer>set1 =new HashSet<>();
            Set<Integer>set2 =new HashSet<>();
            for (int j = 0; j <=i; j++) {
                set1.add(nums[j]);
            }
            for (int k =i+1;k<nums.length;k++){
                set2.add(nums[k]);
            }
            res[i]=set1.size()-set2.size();
        }
       return res;
    }
}
