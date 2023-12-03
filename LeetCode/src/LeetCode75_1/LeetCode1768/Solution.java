package LeetCode75_1.LeetCode1768;

public class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        if (word1.length() == word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                res.append(word1.charAt(i)).append(word2.charAt(i));
            }
            return res.toString();
        } else if (word1.length() > word2.length()) {
            for (int i = 0; i < word2.length(); i++) {
                res.append(word1.charAt(i)).append(word2.charAt(i));
            }
            res.append(word1.substring(word2.length()));
            return res.toString();
        } else {
            for (int i = 0; i < word1.length(); i++) {
                res.append(word1.charAt(i)).append(word2.charAt(i));
            }
            res.append(word2.substring(word1.length()));
            return res.toString();

        }
    }
}
