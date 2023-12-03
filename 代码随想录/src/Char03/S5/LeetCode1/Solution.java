package Char03.S5.LeetCode1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            //第二次 9-7=2 与键相等
            //故直接返回当前数字的下标并通过键寻找该键对应的下标
            //然后总体返回数组
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            //第一次数字一定不存在hashmap里 故存入map集合
            //2---0
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}