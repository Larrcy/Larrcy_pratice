package 基础算法.质数筛;

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
}
