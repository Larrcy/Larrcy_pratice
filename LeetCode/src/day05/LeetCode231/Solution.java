package day05.LeetCode231;

public class Solution {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfTwo(n));

    }

    //位运算
    //若n是正整数且n&(n-1)==0 则n是2的幂
    public static boolean isPowerOfTwo(int n) {
        int count = 0;
        int index = n;
        while (n / 2 != 0) {
            count++;
            n = n / 2;

        }
        return Math.pow(2, count) == index;

    }
}
