package LeetCode75_2.LeetCode2215;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>>res =new ArrayList<>();
        List<Integer>list1 =new ArrayList<>();
        List<Integer>list2 =new ArrayList<>();
        HashSet<Integer>set1=new HashSet<>();
        HashSet<Integer>set2=new HashSet<>();
        Hash(nums1, nums2, res, list1, set2);
        Hash(nums2, nums1, res, list2, set1);
        return res;
    }

    private void Hash(int[] nums1, int[] nums2, List<List<Integer>> res, List<Integer> list1, HashSet<Integer> set2) {
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if(set2.add(nums1[i])){
                list1.add(nums1[i]);
            }
        }
        res.add(list1);
    }

}
