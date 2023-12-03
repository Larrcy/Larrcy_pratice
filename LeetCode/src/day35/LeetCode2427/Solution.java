package day35.LeetCode2427;

public class Solution {
    // x是 a 和 b 的公因子，当且仅当 x 是 a 和 b 的最大公约数的因子。
    //因此，我们可以首先求出 a 和 b 的最大公约数 c，再枚举 c的因子个数。
    public int commonFactors(int a, int b) {
        int c = gcd(a, b), ans = 0;
        for (int x = 1; x * x <= c; ++x) {
            if (c % x == 0) {
                ++ans;
                if (x * x != c) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
       return b==0?a:gcd(b,a%b);
    }
}
