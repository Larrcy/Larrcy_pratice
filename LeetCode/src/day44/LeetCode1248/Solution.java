package day44.LeetCode1248;

import java.util.*;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int preSum = 0;
        for (int num : nums) {
            if (num % 2 != 0) {//判断是否为奇数
                preSum++;
            }
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            if (map.containsKey(preSum)) {
                map.put(preSum, map.get(preSum) + 1);
            } else {
                map.put(preSum, 1);
            }
        }
        return count;
    }

}
