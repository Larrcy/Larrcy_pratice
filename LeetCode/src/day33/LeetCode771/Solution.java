package day33.LeetCode771;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length(); i++) {
            map.put(stones.charAt(i), map.getOrDefault(stones.charAt(i), 0) + 1);
        }
        int sum = 0;
        for (int i = 0; i < jewels.length(); i++) {
            if (map.containsKey(jewels.charAt(i))) {
                sum += map.get(jewels.charAt(i));
            }
        }
        return sum;
    }
}
