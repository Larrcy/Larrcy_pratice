package day10.LeetCode521;

import java.util.Map;

public class Solution {
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        } else return Math.max(a.length(),b.length());
    }
}
