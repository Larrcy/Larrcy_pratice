package day27.LeetCode2550;

public class Solution {
    public int monkeyMove(int n) {
        //快速幂
        //正难则反
        //本题求碰撞次数 我们可以求不发生碰撞的次数
        //则发生碰撞的次数为2^n-2
        int MOD = (int)1e9 + 7;
        long ans = 1;
        long x = 2;
        while (n > 0) {
            //快速幂 n为奇数时将多余的一项x乘以ans
            if (n %2 == 1) {
                ans = ans * x % MOD;
            }
            //正好时
            x = x * x % MOD;
            n =n/2;
        }
        return (int)((ans + MOD - 2) % MOD);
    }
}
