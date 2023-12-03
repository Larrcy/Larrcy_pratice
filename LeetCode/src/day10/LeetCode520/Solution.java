package day10.LeetCode520;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean detectCapitalUse(String word) {
        if(word.length()==1){
            return true;
        }
        if ((word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') && (word.substring(1).toLowerCase().equals(word.substring(1)))) {
            return true;
        }
        if (word.toLowerCase().equals(word)) {
            return true;
        }
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        return false;
    }
}
