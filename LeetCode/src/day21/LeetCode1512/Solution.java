package day21.LeetCode1512;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer>map =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1 );
        }
        int res =0;
        for (Integer value : map.values()) {
            if(value==1)continue;
            res+=value*(value-1)/2;
        }
        return res;
    }
}
