package day37.Week308.LeetCode2390;

public class Solution {
    public String removeStars(String s) {
        if (s.length() == 1) return s;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; ) {
            while (s.charAt(i) == '*') {
                count++;
                i--;
            }
            while (s.charAt(i) != '*' && count > 0) {
                count--;
                i--;
            }
            if (i >= 0&&count==0&&s.charAt(i)!='*') {
                sb.append(s.charAt(i));
                i--;
            }
        }
        return sb.reverse().toString();
    }
}
