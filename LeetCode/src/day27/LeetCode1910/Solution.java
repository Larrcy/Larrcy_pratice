package day27.LeetCode1910;

public class Solution {
    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            String[] split = s.split(part,2);
            s = "";
            for (int i = 0; i < split.length; i++) {
                s += split[i];
            }
        }
        return s;
    }
}
