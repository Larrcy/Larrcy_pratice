package day28.LeetCode1513;

import java.awt.*;

public class Solution {
    public static void main(String[] args) {
        String s="0110111";
        System.out.println(numSub(s));
    }
    public static int numSub(String s) {
        int MODULO = 1000000007;
        String[] split = s.split("0");
        long len =split.length;
        long count =0;
        for (int i = 0; i < len; i++) {
            long slen =split[i].length();
            count+=((slen*(slen+1))/2);
            count%=MODULO;
        }
        return (int) count;
    }
}
