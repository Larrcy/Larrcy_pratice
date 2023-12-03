package day27.LeetCode831;

public class Solution {
    public String maskPII(String s) {
        if (s.contains("@")) {
            StringBuilder sb = new StringBuilder();
            String[] split = s.split("@");
            sb.append(split[0].toLowerCase().charAt(0))
                    .append("*****").append(split[0].toLowerCase().charAt(split[0].toLowerCase().length() - 1))
                    .append("@").append(split[1].toLowerCase());
            return sb.toString();


        } else {
            int numberCount = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    numberCount++;
                }
            }
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    sb.append(s.charAt(i));
                }
                if (sb.length() == 4) {
                    sb = sb.reverse();
                    break;
                }
            }

            if (numberCount == 10) {
                return "***-***-" + sb;
            }
            if (numberCount == 11) {
                return "+*-***-***-" + sb;
            }
            if (numberCount == 12) {
                return "+**-***-***-" + sb;
            }
            if (numberCount == 13) {
                return "+***-***-***-" + sb;
            }


        }
        return "";
    }
}
