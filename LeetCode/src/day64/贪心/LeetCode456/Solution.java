package day64.贪心.LeetCode456;

import java.util.Stack;

/**
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * <p>
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 */

class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3){
            return false;
        }
        //stack用于记录nums[k]
        Stack<Integer> stack = new Stack<Integer>();
        //用tmp来记录nums[k]用于比较nums[i]
        int tmp = Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]<tmp){
                return true;
            }
            //当发现 nums[i]大于栈顶元素时即nums[j]>nums[k]
            //将nums[k]收集起来
            while(!stack.isEmpty() && nums[i]>stack.peek()){
                tmp =  stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}