package day01.LeetCode58;

public class Solution {
    public static void main(String[] args) {
        String s = "day    ";
        System.out.println(s.length());
        System.out.println(lengthOfLastWord(s));


    }

    public static int lengthOfLastWord(String s) {
/*
 String[] split = s.split(" ");
        return split[split.length - 1].length();
 */
        //获得字符串长度
        int length = s.length();
        //去掉末尾为" "的空字符串 并返回字符串长度
        while (length >= 0 && s.charAt(length - 1) == ' ') {
            length = length - 1;

        }


        //对去掉空格的字符串进行倒序遍历
        for (int j = length; j > 0; j--) {
            //当第一次遇到空格字符则返回最后一个单词的长度
            if (s.charAt(j - 1) == ' ') {
                return length - j;
            }


        }
        //全部遍历完后则该字符串无空格字符(去空格符后)
        //直接返回字符长度
        return length;


    }
}