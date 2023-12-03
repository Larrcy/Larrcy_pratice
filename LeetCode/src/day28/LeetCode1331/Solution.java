package day28.LeetCode1331;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int[] nums = Arrays.copyOf(arr, arr.length);
        Arrays.sort(nums);
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], count);
                count++;
            }
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}
