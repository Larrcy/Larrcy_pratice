package day08.LeetCode389;

public class Solution2 {
    public static void main(String[] args) {
        String s = "a";
        String t = "aa";

        System.out.println(findTheDifference(s,t));
    }
    //利用位运算 讲两个字符串拼接起来只需要统计出现奇数次的字符
    public static char findTheDifference(String s, String t) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            ret ^= t.charAt(i);
        }
        return (char) ret;
    }

}
