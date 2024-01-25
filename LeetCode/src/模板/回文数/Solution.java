package 模板.回文数;

public class Solution {
    private boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = 0, num = x;
        while (num != 0) {
            y = y * 10 + num % 10;
            num /= 10;
        }
        return y == x;
    }


}
