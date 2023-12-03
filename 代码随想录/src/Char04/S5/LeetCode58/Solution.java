package Char04.S5.LeetCode58;

public class Solution {
    public static void main(String[] args) {

    }
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb =new StringBuilder(s);
        reverseString(sb,0,n-1);
        reverseString(sb,n,s.length()-1);
        return sb.reverse().toString();

    }
    public static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
