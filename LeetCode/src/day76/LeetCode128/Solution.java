package day76.LeetCode128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (Integer num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int curNum = num;
            int len = 0;
            while (set.contains(curNum + 1)) {
                len++;
                curNum++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
