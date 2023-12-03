package day09.LeetCode482;

public class Solution {
    public static void main(String[] args) {
        String s = "2-4A0r7-4k";
        int k = 3;
        System.out.println(licenseKeyFormatting(s, k));

    }

    public static String licenseKeyFormatting(String s, int k) {
        s = s.toUpperCase();
        String res = "";
        String[] split = s.split("-");
        for (int i = 0; i < split.length; i++) {
            res = res + split[i];
        }
        if (res.length() == 1) {
            return res;
        }
        String m = "";
        if (res.length() % k != 0) {
            for (int i = 0; i < res.length() % k; i++) {
                m = m + res.charAt(i);
            }
            m = m + "-";
            res = res.substring(res.length() % k);
            for (int i = 0; i < res.length(); i++) {
                m = m + res.charAt(i);
                if ((i + 1) % k == 0 && i != res.length() - 1) {
                    m = m + "-";
                }

            }
            return m;
        } else {
            for (int i = 0; i < res.length(); i++) {
                m = m + res.charAt(i);
                if ((i + 1) % k == 0 && i != res.length() - 1) {
                    m = m + "-";
                }

            }
            return m;

        }
    }
}

