package Offer1.S2;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder s1 = new StringBuilder(s.substring(0, n));
        StringBuilder s2 = new StringBuilder(s.substring(n));
        return s2.append(s1).toString();

    }


}
