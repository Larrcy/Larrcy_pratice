package day34.LeetCode598;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }
        return m * n;
    }
}
