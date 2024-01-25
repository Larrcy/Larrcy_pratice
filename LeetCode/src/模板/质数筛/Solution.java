package 模板.质数筛;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    static int num = 10000000;
    static Set<Integer> set = new HashSet<>();
    static{
        //埃氏筛法
        boolean[] flag = new boolean[num + 1];
        for(int i = 2;i <= num / 2;i++) {
            if(!flag[i]) {
                set.add(i);
                for(int j = i;j <= num / i;j++) {
                    flag[j * i] = true;
                }
            }
        }
    }
    /**
     *    private final static int MX = 1000;
     *     private final static int[] arr = new int[169];
     *
     *     static {
     *         boolean[] np = new boolean[MX + 1];
     *         int pi = 1; // primes[0] = 0 避免二分越界
     *         for (int i = 2; i <= MX; ++i)
     *             if (!np[i]) {
     *                 arr[pi++] = i; // 预处理质数列表
     *                 for (int j = i; j <= MX / i; ++j)
     *                     np[i * j] = true;
     *             }
     *     }
     */
}
