package day18.LeetCode53;

//贪心算法
public class Solution {
    public int maxSubArray(int[] nums) {
        int count =0;
        int res =Integer.MIN_VALUE;
        for (int i = 0; i < nums.length;i++) {
            count=count+nums[i];
            //顺序不能颠倒

            if(count>res){
                res=count;
            }
            if(count<0){
                count=0;
            }

        }
        return res;

    }
}
