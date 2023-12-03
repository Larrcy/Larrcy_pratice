package day68.双指针.LeetCode1577;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你返回根据以下规则形成的三元组的数目（类型 1 和类型 2 ）：
 * <p>
 * 类型 1：三元组 (i, j, k) ，如果 nums1[i]2 == nums2[j] * nums2[k] 其中 0 <= i < nums1.length 且 0 <= j < k < nums2.length
 * 类型 2：三元组 (i, j, k) ，如果 nums2[i]2 == nums1[j] * nums1[k] 其中 0 <= i < nums2.length 且 0 <= j < k < nums1.length
 */
public class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Long, Integer> map1 = new HashMap<>();
        Map<Long, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                Long num =  ((long) nums1[i] * nums1[j]);
                map1.put( num, map1.getOrDefault(num, 0) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                Long num =((long) nums2[i] * nums2[j]);
                map2.put(num , map2.getOrDefault(num, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (map2.containsKey((long)nums1[i] * nums1[i])) {
                res += map2.get((long)nums1[i] * nums1[i]);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map1.containsKey((long)nums2[i] * nums2[i])) {
                res += map1.get((long)nums2[i] * nums2[i]);
            }
        }
        return res;
    }
}
