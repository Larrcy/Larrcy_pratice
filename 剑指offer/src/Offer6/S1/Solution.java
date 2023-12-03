package Offer6.S1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int search(int[] nums, int target) {
        Map<Integer,Integer>map =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1 );
        }
        return map.get(target)==null?0: map.get(target);
    }
}
