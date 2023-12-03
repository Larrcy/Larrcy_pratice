package day23.LeetCode2490;

public class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");
        if (sentence.length() == 1 && sentence.charAt(0) == sentence.charAt(sentence.length() - 1)) return true;
        int count = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[0].charAt(0) == s[s.length - 1].charAt(s[s.length - 1].length() - 1)) {
                count++;
            }
            if(s[i].charAt(0)==s[i-1].charAt(s[i-1].length()-1)){
                count++;
            }
        }
        return count==s.length?true:false;
    }
}
