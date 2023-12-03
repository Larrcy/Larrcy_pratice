package day10.LeetCode8;

public class Solution {
    public static void main(String[] args) {

    }

    public int myAtoi(String s) {

        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        long count = 0;
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9') {
            int i = 0;
            while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count = count * 10 + s.charAt(i) - '0';
                if (i == s.length() - 1) {
                    break;
                }
                i++;
                if (count > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

            }
            if (count > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else
                return (int) count;


        }
        if (s.charAt(0) == '+') {
            if (s.length() == 1) {
                return 0;
            }
            int i = 1;
            while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count = count * 10 + s.charAt(i) - '0';
                if (i == s.length() - 1) {
                    break;
                }
                i++;
                if (count > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            }
            if (count > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else
                return (int) count;

        }
        if (s.charAt(0) == '-') {
            if (s.length() == 1) {
                return 0;
            }
            int i = 1;
            while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                count = count * 10 + s.charAt(i) - '0';
                if (i == s.length() - 1) {
                    break;
                }
                i++;
                if (count > 2147483648L) {
                    return Integer.MIN_VALUE;
                }
            }
            if (count > 2147483648L) {
                return Integer.MIN_VALUE;
            } else
                return (int) -count;

        }
        return 0;
    }
}
