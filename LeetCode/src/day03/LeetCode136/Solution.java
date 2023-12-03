package day03.LeetCode136;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] nums ={1,1,2};
        System.out.println(singleNumber(nums));


    }
//只出现一次的数字（可用循环异或）
    public static int singleNumber(int[] nums) {
        //对数组进行排序
        Arrays.sort(nums);
        //利用双指针
        int p = 0;
        int q = 1;

        //只会出现1 3 5 7...
        //故双指针同时移动对应的循环次数为1 2 3...
        //循环次数可以减半
        for (int i = 1; i <=nums.length/2; i++) {
            //若出现不相等的情况则直接返回p位置的数
            if(nums[p]!=nums[q]){
                return nums[p];
            }
            //若相等则双指针同时后移2位
            p=q+1;
            //为防止越界
            //当判断到最后一位时前面的都相等 则最后一位一定出现了一次
            if(p==nums.length-1){
                return nums[nums.length-1];
            }
            q=p+1;
        }
        //若长度为1 则返回数组第一位
        return nums[0];
    }
}

