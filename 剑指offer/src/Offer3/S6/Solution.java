package Offer3.S6;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (temp < 0) {
                return null;
            }
            int left =0;
            int right =nums.length-1;
            while (left<=right){
                int mid=left+(right-left)/2;
                if(nums[mid]==temp){
                    res[0]=nums[i];
                    res[1]=nums[mid];
                    return res;
                }
                if(nums[mid]>temp){
                    right=mid-1;
                }else {
                    left=mid+1;
                }
            }
        }
        return res;
    }
}
