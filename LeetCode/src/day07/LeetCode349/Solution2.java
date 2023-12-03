package day07.LeetCode349;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {

    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
           if(set.contains(nums2[i])){
               set2.add(nums2[i]);
           }
        }
        //maptoInt可以把set转换为数组
      return set2.stream().mapToInt(x->x).toArray();
    }
}
