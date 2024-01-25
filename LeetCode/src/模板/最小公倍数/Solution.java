package 模板.最小公倍数;

public class Solution {
    //求最小公倍数
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    //最大公约数
    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
