package day35.LeetCode2404;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int mostFrequentEven(int[] nums) {
        TreeMap<Integer,Integer>map =new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==0){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1 );
            }
        }
        int max =0;
        for (Integer key : map.keySet()) {
            if(map.get(key)>max){
                max=map.get(key);
            }
        }
        for (Integer key : map.keySet()) {
            if(map.get(key)==max){
                return key;
            }
        }
        return -1;
    }
}
