package day45.LeetCode1296;

import java.util.*;

public class Solution2 {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (map.size() != 0) {
            int x = map.firstKey();
            for (int i = 1; i < k; i++) {
                if (!map.containsKey(x + i)) return false;
                map.put(x + i, map.get(x + i) - 1);
                if (map.get(x + i) == 0) map.remove(x + i);
            }
            map.put(x, map.get(x) - 1);
            if (map.get(x) == 0) map.remove(x);
        }
        return true;

    }
}
