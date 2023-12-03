package Char04.S1.LeetCode344;

public class Solution {
    public void reverseString(char[] s) {
        for( int p =0, q =s.length-1;p<q;p++,q--){
            char tmp = s[p];
            s[p] = s[q];
            s[q] = tmp;
        }


    }
}