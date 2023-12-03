package day26.LeetCode2124;

public class Solution {
    public boolean checkString(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == 'a') {
                left++;
            }
            if (s.charAt(right) == 'b') {
                right--;
            }
            if(s.charAt(left)=='b'&&s.charAt(right)=='a'&&left<right){
                return false;
            }
        }
        return true;
    }
}
