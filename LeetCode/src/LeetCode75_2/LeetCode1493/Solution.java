package LeetCode75_2.LeetCode1493;

public class Solution {
    public static void main(String[] args) {
        int[]nums ={0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(nums));
    }
    public static int longestSubarray(int[] nums) {
            int n=nums.length;
            int res=0;
            int left =0;
            int right =0;
            int count=0;
            while (right<nums.length){
                if(nums[right]==0){
                    count++;
                }
                right++;
                while (count>1){
                    if(nums[left]==0){
                        count--;
                    }
                    left++;
                }
                //res1 = 1-0-1 =0
                //res2 = 2-0-1 =1
                //res3 = 3-0-1 =2
                //res4 = 4-0-1 =3

                //res5 = 5-1-1 =3
                //res6 = 6-1-1 =4
                //res7 = 7-1-1 =5

                //res8 = 8-5-1 =2
                //res9 = 9-5-1 =3
                res=Math.max(res,right-left-1);
            }
            return res;
    }
}
