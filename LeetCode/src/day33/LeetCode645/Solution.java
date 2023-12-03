package day33.LeetCode645;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[]res =new int[2];
        Set<Integer>set=new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])){
                res[0]=nums[i];
            }
        }
        for (int i = 1; i <=nums.length; i++) {
            if(set.add(i)){
                res[1]=i;
            }
        }
        return res;
    }
}
