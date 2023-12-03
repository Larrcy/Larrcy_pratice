package day08.LeetCode283;

public class Solution2 {
    public void moveZeroes(int[] nums) {
        /*  0 1 0 3 12
            1 0 0 3 12
            1 3 0 0 12
            1 3 12 0 0 */

        for (int p = 0,q=1; q < nums.length;) {
            if (nums[p]==0&&nums[q]!=0){
                swap(nums,p,q);
                p++;
                q++;
            }
           else if (nums[p]==0&&nums[q]==0){
                q++;
            }else{
               p++;
               q++;
            }
        }

    }
    //变量才能进行交换
    public void swap(int[]nums,int p,int q) {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}


