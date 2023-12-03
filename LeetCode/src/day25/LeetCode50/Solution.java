package day25.LeetCode50;

public class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
    }

    //快速幂
    public double quickPow(double x, long y) {
        if (y == 0) {
            return 1.0;
        }
        double ret = quickPow(x, y / 2);
        //将y次方每次除以2进行判断
        //若能整除则进行拆分
        //若不能整除 则多出一个x
        return y % 2 == 0 ? ret * ret : ret * ret * x;
    }
}
