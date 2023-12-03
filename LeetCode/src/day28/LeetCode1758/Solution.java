package day28.LeetCode1758;

public class Solution {

    public int minOperations(String s) {
        //要是交替字符串，那么必然是101010或者010101这两种形式，
        //那么一个字符串就可以通过修改字符来变成这两个形式
        //分别统计两个形式的操作数，两者取小就是答案
        int res1 = 0, res2 = 0;
        //讲原字符串变为 101010 形式需要的操作数
        for (int i = 0; i < s.length(); ++i) {
            if (i % 2 == 1) {
                if (s.charAt(i) == '1') res1++;
            } else {
                if (s.charAt(i) == '0') res1++;
            }
        }
        //讲原字符串变为 010101 形式需要的操作数
        for (int i = 0; i < s.length(); ++i) {
            if (i % 2 == 1) {
                if (s.charAt(i) == '0') res2++;
            } else {
                if (s.charAt(i) == '1') res2++;
            }
        }
        //取两者较小值
        return Math.min(res1, res2);
    }


}
