package day49.Week313.LeetCode2427;

public class Solution {
    public int commonFactors(int a, int b) {
        int i = Math.min(a, b);
        int count = 0;
        for (int j = 1; j <= i; j++) {
            if (a % j == 0 && b % j == 0)
                count++;
        }
        return count;
    }
}
