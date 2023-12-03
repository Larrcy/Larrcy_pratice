package Offer10;

public class Solution {
    public int fib(int n) {
        int[] f = new int[n+1];
        if(n==1)return 1;
        if(n==0)return 0;
        f[0] = 0;
        f[1] = 1;
        for (int i = 3; i <= n; i++) {
            f[i]=(f[i-1]+f[i-2])%1000000007;
        }
        return f[n];
    }
}
