package 模板.快速幂;

public class pow {
    int pow_mod(long a, int b, int mod) {
        long res = 1;
        while (b != 0) {
            if (b % 2 == 1) res = (res * a) % mod;
            b >>= 1;
            a = (a * a) % mod;
        }
        return (int)res;
    }


}
