package day08.LeetCode2521;

import java.util.HashSet;

public class Solution {
    public int distinctPrimeFactors(int[] nums) {
        //保证数组去重使用哈希表
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            //求质数枚举到跟下x
            //i只需要枚举到跟下x即可
            for (int i = 2; i * i <= x; i++) {
                if (x % i == 0) {
                    //将质数添加到集合
                    set.add(i);
                    //对将x能除的质数全都除去
                    while (x % i == 0)
                        x /= i;
                }
            }
            //将所有数除尽之后若还剩下一个数则一定是个质数 添加进去
            if (x > 1)
                set.add(x);
        }
        return set.size();
    }
}
