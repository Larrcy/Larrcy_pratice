package day77.LeetCode438;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cnt1[p.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt2[s.charAt(i) - 'a']++;
            sb.append(s.charAt(i));
            while (sb.length() > p.length()) {
                sb.deleteCharAt(0);
                cnt2[s.charAt(left) - 'a']--;
                left++;
            }
            if (sb.length() == p.length() && isValid(cnt1, cnt2)) {
                res.add(left);
            }
        }
        return res;
    }

    boolean isValid(int[] cnt1, int[] cnt2) {
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
    }
}
