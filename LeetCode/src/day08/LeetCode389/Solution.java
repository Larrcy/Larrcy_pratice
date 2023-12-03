package day08.LeetCode389;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "a";
        String t = "aa";

        System.out.println(findTheDifference(s,t));
    }
    //每个字符的 ASCII 码的值求和 然后求差值转换即可
    public  static char findTheDifference(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

}
