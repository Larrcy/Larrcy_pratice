package Char03.S3.LeetCode350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {61, 24, 20, 58, 95, 53, 17, 32, 45, 85, 70, 20, 83, 62, 35, 89, 5, 95, 12, 86, 58, 77, 30, 64, 46, 13, 5, 92, 67, 40, 20, 38, 31, 18, 89, 85, 7, 30, 67, 34, 62, 35, 47, 98, 3, 41, 53, 26, 66, 40, 54, 44, 57, 46, 70, 60, 4, 63, 82, 42, 65, 59, 17, 98, 29, 72, 1, 96, 82, 66, 98, 6, 92, 31, 43, 81, 88, 60, 10, 55, 66, 82, 0, 79, 11, 81};
        int[] nums2 = {5, 25, 4, 39, 57, 49, 93, 79, 7, 8, 49, 89, 2, 7, 73, 88, 45, 15, 34, 92, 84, 38, 85, 34, 16, 6, 99, 0, 2, 36, 68, 52, 73, 50, 77, 44, 61, 48};
        System.out.println(intersect(nums1, nums2));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            // map.getOrDefault :
            // 当Map集合中有这个key时，就使用这个key值；
            //如果没有就使用默认值defaultValue
            //map.getOrDefault(num, 0) + 1表示该数的个数
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //新建数组存储交集
        //长度大小都可 最后还要截取
        int[] res = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            //遍历nums2是否与nums1有交集
            //若存在一次则个数减一
            //map.get(num) > 0是为了保证取两数组中数字出现少的那个数组
            if (map.containsKey(num) && map.get(num) > 0) {
                res[index++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        // 对已有([9, 4, 0])的数组进行截取和赋值,结果为[9,4]
        return Arrays.copyOfRange(res, 0, index);
    }
}
