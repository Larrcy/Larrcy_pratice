package day29.LeetCode2554;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (set.add(i)) {
                sum += i;
                count++;
            }
            if (sum > maxSum) {
                return count - 1;
            }
        }
        return count;
    }
}

