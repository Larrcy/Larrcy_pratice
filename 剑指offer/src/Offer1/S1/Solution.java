package Offer1.S1;

public class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
