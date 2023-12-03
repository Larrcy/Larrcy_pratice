package Char01.S2.LeetCode35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        //二分查找
        int l = 0;
        int r = nums.length - 1;
        while (l<=r){
            int mid =(r+l)/2;
            if(nums[mid]<target){
                l =mid+1;
            }
            else
                r=mid-1;
        }
        return l;
    }
}
