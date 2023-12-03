package day15.LeetCode496;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 ={137,59,92,122,52,131,79,236};
        int[] nums2 ={137,59,92,122,52,131,79,236};
        System.out.println(nextGreaterElement(nums1, nums2));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map2 = new HashMap<>();
        int[] res =new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int j =map2.get(nums1[i]);

             if(j==nums2.length-1){
                 res[i]=-1;
             }
            int index =j+1;
             while (j<nums2.length-1){
                 if(index==nums2.length){
                     res[i]=-1;
                     break;
                 }
                 if(nums2[index]<nums2[j]){
                     index++;
                 }else {
                     res[i]=nums2[index];
                     break;
                 }
             }
        }
    return res;
    }
}
