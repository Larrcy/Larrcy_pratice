package Char01.S2.LeetCode367;

public class Solution {
    public static void main(String[] args) {
        int num = 7;
        isPerfectSquare(num);
    }
    public static boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            //防止越界
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
