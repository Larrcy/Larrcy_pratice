package day44.LeetCode1695;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer>set=new HashSet<>();
        int left=0;
        int count=0;
        int max =0;
        for (int i = 0; i < nums.length; i++) {
            while (set.contains(nums[i])){
                max=Math.max(max,count);
                set.remove(nums[left]);
                count-=nums[left];
                left++;
            }
            if (!set.contains(nums[i])){
                set.add(nums[i]);
                count+=nums[i];
            }

        }
        return max;
    }
}
