package day50.LeetCode680;

public class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int count = 0;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                count++;
                right--;

            }
        }
        int left1 = 0;
        int right1 = s.length()-1;
        int count1 = 0;
        while (left1 < right1) {
            if (s.charAt(left1) == s.charAt(right1)) {
                left1++;
                right1--;
            } else {
                count1++;
                left1--;

            }
        }
        return Math.min(count1, count) <= 1;

    }
}
