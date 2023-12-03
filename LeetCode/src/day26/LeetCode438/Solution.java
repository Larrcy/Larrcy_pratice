package day26.LeetCode438;


import java.util.*;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int[] c1 = new int[26], c2 = new int[26];
        //记录c2元素出现的次数
        for (int i = 0; i < p.length(); i++) c2[p.charAt(i) - 'a']++;
        for (int right = 0; right < n; right++) {
            //记录c1的元素出现次数
            c1[s.charAt(right) - 'a']++;
            sb.append(s.charAt(right));
            if (sb.length() > p.length()) {
                sb.deleteCharAt(0);
                //若多了则将left位置的元素减去
                c1[s.charAt(left) - 'a']--;
                left++;
            }
            if (sb.length() == p.length() && isWord(c1, c2)) {
                res.add(left);
            }
        }
        return res;
    }

    public boolean isWord(int[] c1, int[] c2) {
        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }

}
