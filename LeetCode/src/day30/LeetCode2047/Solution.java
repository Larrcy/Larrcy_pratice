package day30.LeetCode2047;

public class Solution {
    public int countValidWords(String sentence) {
        int res = 0;
        for (String m: sentence.split(" ")) {
            if (m.length() != 0 && m.matches("^[a-z]*([a-z]-[a-z]+)?[!.,]?$")) res++;
        }
        return res;
    }
}
