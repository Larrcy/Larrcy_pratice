package day45.Week336;

public class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if ((words[i].startsWith("a") ||
                    words[i].startsWith("e") ||
                    words[i].startsWith("i") ||
                    words[i].startsWith("o") ||
                    words[i].startsWith("u")) && (
                    words[i].endsWith("a") ||
                            words[i].endsWith("e") ||
                            words[i].endsWith("i") ||
                            words[i].endsWith("o") ||
                            words[i].endsWith("u")
            )) count++;


        }
        return count;
    }
}
