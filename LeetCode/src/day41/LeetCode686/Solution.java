package day41.LeetCode686;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        int max = 2 * a.length() + b.length();
        while (sb.length() < max) {
            sb.append(a);
            ans++;
            if (sb.toString().contains(b)) return ans;
        }
        return -1;
    }

}
