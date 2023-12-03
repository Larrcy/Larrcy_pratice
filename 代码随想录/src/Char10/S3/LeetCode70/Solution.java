package Char10.S3.LeetCode70;

public class Solution {
    public int climbStairs(int n) {
        int[] F = new int[46];
        F[1] = 1;
        F[2] = 2;
        if(n==1)return 1;
        if(n==2)return 2;
        for (int i = 3; i <=n; i++) {
            F[i]=F[i-1]+F[i-2];
        }
        return F[n];
    }
}
