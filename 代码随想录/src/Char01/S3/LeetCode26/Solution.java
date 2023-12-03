package Char01.S3.LeetCode26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        //快慢指针法
        int p = 0;
        int q = 1;
        while(q < nums.length){
            //若p q所指位置的元素不相等则将q位置的元素赋值到p+1位置上
            //若赋值在p位置上则会导致数值丢失
            if(nums[p] != nums[q]){
                nums[p + 1] = nums[q];
                p++;
            }
            //若p q所指位置元素相等则 q后移
            q++;
        }
        //最后返回最后索引位置
        return p + 1;
    }
}
