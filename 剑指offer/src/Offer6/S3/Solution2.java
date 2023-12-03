package Offer6.S3;

public class Solution2 {
    //二分
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == mid){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}
