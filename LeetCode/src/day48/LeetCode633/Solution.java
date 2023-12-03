package day48.LeetCode633;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean judgeSquareSum(int c) {
        int n = (int) Math.sqrt(c);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            set.add(i * i);
            if (set.contains(c - i * i))
                return true;
        }
        return false;

    }
}
