package Offer3.S5;

public class Solution {
    public int[] exchange(int[] nums) {
        for (int p =0,q=1;q<nums.length;){
            if(nums[p]%2==0&&nums[q]%2!=0){
                swap(nums,p,q);
                p++;
                q++;
            }else if(nums[p]%2==0&&nums[q]%2==0){
                q++;
            }else {
                p++;
                q++;
            }
        }
        return nums;

    }
    public void swap(int[] nums, int p, int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}
