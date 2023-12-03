package day04.LeetCode4;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 ={1,2};
        int[] nums2 ={3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums =new int[nums1.length+nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i]=nums1[i];
        }
        int j =nums1.length;
        for (int i = 0; i < nums2.length; i++) {
            nums[j]=nums2[i];
            j++;
        }
        Arrays.sort(nums);
        if(nums.length%2==0){
            return (nums[nums.length/2-1]+nums[nums.length/2])/2.0;
        }
        else return nums[nums.length/2];

    }
}
