package day14.LeetCode58;

public class Solution2 {
    public static void main(String[] args) {

    }
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb =new StringBuilder( s.substring(n));
        String s1 = s.substring(0, n);
        sb.append(s1);
        return sb.toString();


    }

}
