package Char10.S52.LeetCode647;

public class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;
        //情况一：下标i 与 j相同，同一个字符例如a，当然是回文子串
        //情况二：下标i 与 j相差为1，例如aa，也是回文子串
        //情况三：下标i 与 j相差大于1的时候，例如cabac，此时s[i]与s[j]已经相同了，
        //我们看i到j区间是不是回文子串就看aba是不是回文就可以了，
        //那么aba的区间就是 i+1 与 j-1区间，这个区间是不是回文就看dp[i + 1][j - 1]是否为true。
        //根据递推公式来判断遍历方向
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) { // 情况一 和 情况二
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) { //情况三
                        result++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return result;
    }

}

