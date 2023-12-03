package day45.LeetCode2344;

import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        for (Integer key : map.keySet()) {
            for (int i = 0; i < numsDivide.length; i++) {
                if (numsDivide[i] % key != 0) {
                    count += map.get(key);
                    break;
                }
                if (i == numsDivide.length - 1) {
                    return count == nums.length ? -1 : count;
                }
            }
        }
        return -1;
    }
}
