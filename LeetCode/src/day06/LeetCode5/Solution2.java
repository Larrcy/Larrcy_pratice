package day06.LeetCode5;

//中心扩散法
public class Solution2 {
    public String longestPalindrome(String s) {
        String res1 = "";
        String res2 = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = func(s, i, i);
            String s2 = func(s, i, i + 1);
            if (res1.length() < s1.length()) {
                res1 = s1;
            }
            if (res2.length() < s2.length()) {
                res2 = s2;
            }
        }
        return res1.length() > res2.length() ? res1 : res2;
    }

    public String func(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

}
