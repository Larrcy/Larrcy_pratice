package day60.LeetCpde1726;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。
 * 其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 */
public class Solution {
    public static void main(String[] args) {
        int[]nums ={2,3,4,6,8,12};
        System.out.println(tupleSameProduct(nums));
    }
    public static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) > 1) {
                res += map.get(key)*(map.get(key)-1) * 4;
            }
        }
        return res;
    }
}
