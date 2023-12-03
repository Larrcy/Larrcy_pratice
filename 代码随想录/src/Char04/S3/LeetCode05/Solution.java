package Char04.S3.LeetCode05;

public class Solution {
    public static void main(String[] args) {
        String s =" ";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        System.out.println(s.length());
        return s.replaceAll(" ", "%20");

    }
}