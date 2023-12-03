package day38.LeetCode1750;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int minimumLength(String S) {
        int l = 0, r = S.length() - 1;
        char[] s = S.toCharArray();
        while (l < r && s[l] == s[r]) {
            char c = s[l];
            while (l <= r && s[l] == c) l++;
            while (l <= r && s[r] == c) r--;
        }
        return r - l + 1;
    }

}
