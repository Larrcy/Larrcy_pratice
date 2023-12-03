package day02.LeetCode125;

public class Solution {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    //回文数
    //如果在将所有大写字符转换为小写字符、
    // 并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
    //字母和数字都属于字母数字字符。
    public static boolean isPalindrome(String s) {
        //tringBuilder无法使用转换小写函数
        String temp = "";
        String result = "";
        //对字符串进行纯英文数字转换
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                temp += s.charAt(i);
            }
        }
        //若为空 则直接返回 true
        if (temp == null || temp == "") {
            return true;
        }
        //对字符串进行小写转换
        temp = temp.toLowerCase();
        //对字符串进行回文判断
        for (int i = temp.length() - 1; i >= 0; i--) {
            result += temp.charAt(i);

        }
        if (temp.equals(result)) {
            return true;
        } else {
            return false;
        }

    }
}
