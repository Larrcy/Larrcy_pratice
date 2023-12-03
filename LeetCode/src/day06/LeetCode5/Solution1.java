package day06.LeetCode5;

public class Solution1 {

    //动态规划
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxlenth = 0;
        int left = 0;
        int right = 0;
        //情况一：下标i 与 j相同，同一个字符例如a，是回文子串
        //情况二：下标i 与 j相差为1，例如aa，也是回文子串
        //情况三：下标i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，
        //我们看i到j区间是不是回文子串就看aba是不是回文就可以了，
        //那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看dp[i + 1][j - 1]是否为true。
        //根据递推公式来判断遍历方向
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) { // 情况一 和 情况二
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) { //情况三
                        dp[i][j] = true;
                    }
                }

                if (dp[i][j] && j - i + 1 > maxlenth) {
                    //判断最长
                    maxlenth = j - i + 1;
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left,right+1);
    }
}
