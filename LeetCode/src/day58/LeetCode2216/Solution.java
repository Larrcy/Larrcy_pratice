package day58.LeetCode2216;

import java.util.Stack;

public class Solution {
    public int minDeletion(int[] nums) {
        Stack<Integer>stack=new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if(stack.isEmpty()){
                stack.push(nums[i]);
                continue;
            }
            if(stack.size()%2!=0&&stack.peek()!=nums[i]){
               stack.push(nums[i]);
            }
           else if(stack.size()%2==0){
               stack.push(nums[i]);
            }
        }
        return stack.size()%2==0?nums.length-stack.size():nums.length-stack.size()+1;
    }
}
