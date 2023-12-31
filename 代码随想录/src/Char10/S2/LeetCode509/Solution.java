package Char10.S2.LeetCode509;

public class Solution {
    public int fib(int n) {
        int[] F = new int[31];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i < n; i++) {
            F[i]=F[i-1]+F[i-2];
        }
        return F[n];
    }
}
