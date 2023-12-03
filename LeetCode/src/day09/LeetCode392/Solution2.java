package day09.LeetCode392;

public class Solution2 {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        while (i < s.length()) {
            int k = i;
            for (int j = k; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                }
            }
        }
       return i==s.length();
    }
}
