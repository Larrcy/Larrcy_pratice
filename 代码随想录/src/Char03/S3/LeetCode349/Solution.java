package Char03.S3.LeetCode349;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(intersection(nums1, nums2));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            l1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            l2.add(nums2[i]);
        }
        //取两集合交集
        l1.retainAll(l2);
        //对集合去重得到新集合
        List<Integer> l3 = l1.stream().distinct().collect(Collectors.toList());
        int[] res = new int[l3.size()];
        for (int i = 0; i < l3.size(); i++) {
            res[i] = l3.get(i);
        }

        return res;
    }
}
