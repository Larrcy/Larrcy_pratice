package day30.LeetCode1328;

public class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";
        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 'a') {
                char index = chars[i];
                chars[i] = 'a';
                if (!isPalindrome(String.valueOf(chars))) {
                    return String.valueOf(chars);
                } else {
                    chars[i] = index;
                    chars[chars.length - 1] = 'b';
                    return String.valueOf(chars);
                }
            }
            if (i == chars.length - 1) {
                chars[i] = 'b';
                return String.valueOf(chars);
            }
        }
        return "";
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
