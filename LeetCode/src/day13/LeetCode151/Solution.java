package day13.LeetCode151;

public class Solution {
    public static void main(String[] args) {
        String s="a good   example";
        System.out.println(reverseWords(s));

    }

    public static String reverseWords(String s) {
        if(s.length()==1){
            return s;
        }
        String[] split = s.trim().split(" ");
        String res = "";
        for (int i = split.length - 1; i >= 0; i--) {
            if(split[i].equals("")){
                continue;
            }
            res = res + split[i];
            if (i != 0) {
                res = res + " ";
            }
        }
        return res;

    }
}
