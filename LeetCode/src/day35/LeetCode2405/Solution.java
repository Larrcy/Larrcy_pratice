package day35.LeetCode2405;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                count++;
                set.clear();
                i--;
            }
        }
        return count+1;
    }
}
