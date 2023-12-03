package day31.New.AC.LeetCode1394;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findLucky(int[] arr) {
int max =-1;
        Map<Integer,Integer>map =new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for (Integer key: map.keySet()) {
            if(map.get(key)==key){
               if(max<key){
                   max=key;
               }
            }
        }
        return max;
    }
}
