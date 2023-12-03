package Offer12.S1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer>map =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Integer key : map.keySet()) {
            if(map.get(key)>nums.length/2){
                return key;
            }
        }
        return -1;
    }
}
