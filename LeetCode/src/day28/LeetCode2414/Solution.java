package day28.LeetCode2414;

public class Solution {
    public int longestContinuousSubstring(String s) {
        int count =0;
        int max =0;
        for (int i = 1; i < s.length();) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                i++;
                count++;
            }
            else {
                count=1;
                i++;
            }
            max=Math.max(max,count);
        }
        return max;

    }
}
