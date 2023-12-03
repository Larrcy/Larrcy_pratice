package LeetCode75_1.LeetCode1071;

public class Solution2 {
    //数学法
    //判断str1与str2拼接后是否等于str2和str1拼接起来的字符串
    //若相等则输出长度为gcd(len1,len2)的前缀串即可，否则返回空串
    public String gcdOfStrings(String str1, String str2) {
        //concat:拼接数组/字符串
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

}
