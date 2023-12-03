package day06.LeetCode338;

public class Solution1 {
    //方法一：调用工具类
    public int[] countBits(int n) {
        int[] ret =new int[n+1];
        for (int i = 0; i < n; i++) {
            //Integer.bitCount()统计二进制数中的1的个数
            ret[i] =Integer.bitCount(i);
        }
        return ret;


    }
}
