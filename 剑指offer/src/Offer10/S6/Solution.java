package Offer10.S6;

public class Solution {
    public static int translateNum(int num) {
        //转换成字符数组
        char[] ch = String.valueOf(num).toCharArray();
        int len = ch.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        //字符串的第i位置
        //可以单独作为一位来翻译
        //如果第 i−1位和第 i位组成的数字在 10到 25之间，可以把这两位连起来翻译
        for(int i = 2; i <= len; i++){
            //判断当前位置和当前位置的前一位能否构成10-25之间的数 若能构成则可以通过
            // dp[i] = dp[i - 1] + dp[i - 2]推出下一位
            int n = (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0');
            if(n >= 10 && n <= 25){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                //若是单独的一位则无影响 跟前面的相同
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}
