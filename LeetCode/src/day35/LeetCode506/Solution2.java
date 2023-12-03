package day35.LeetCode506;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public String[] findRelativeRanks(int[] score) {
        int[] nums = Arrays.copyOf(score, score.length);
        Arrays.sort(nums);
        String[] res = new String[score.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < score.length; i++) {
            if (score.length - map.get(score[i]) == 1) {
                res[i] = "Gold Medal";
            } else if (score.length - map.get(score[i]) == 2) {
                res[i] = "Silver Medal";
            } else if (score.length - map.get(score[i]) == 3) {
                res[i] = "Bronze Medal";
            } else res[i] = String.valueOf(score.length - map.get(score[i]));
        }
        return res;
    }
}
