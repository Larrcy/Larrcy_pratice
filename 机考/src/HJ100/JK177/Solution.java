package HJ100.JK177;

import java.util.Scanner;
//***找出重复代码
public class Solution {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
            String text1 = scanner.nextLine();
            String text2 = scanner.nextLine();
            String res = func(text1, text2);
            System.out.println(res);
        }


    private static String func(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        int maxLen = 0;
        int right = 0;
        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if (s1[i] == s2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i + 1][j + 1] > maxLen) {
                        maxLen = dp[i + 1][j + 1];
                        right = i;
                    }
                }
            }
        }
        if (maxLen == 0) {
            return "";
        } else {
            return text1.substring(right - maxLen + 1, right + 1);
        }
    }
}
