package day35.LeetCode697;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        int l = 0, r , len = nums.length, res = len + 1;
        Map<Integer, Integer> map = new HashMap<>();
        //获取最大的度
        int maxDegree = getDegree(nums);

        for ( r = 0; r < len; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            //当第二次遍历达到最大的度时
            //利用滑动窗口进行截取连续的最小子数组
            while (map.get(nums[r]) == maxDegree) {
                map.put(nums[l], map.get(nums[l]) - 1);
                res = Math.min(res, r - l+1);
                l++;
            }
        }
        return res;
    }

    public int getDegree(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            res = Math.max(res, map.get(i));
        }
        return res;
    }

}
