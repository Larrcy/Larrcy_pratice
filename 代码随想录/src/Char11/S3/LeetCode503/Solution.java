package Char11.S3.LeetCode503;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //环形的处理逻辑
        //遍历数组时遍历其两倍的数组长度
        //然后下标i对nums.length进行取余操作即可循环遍历
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        stack.push(0);
        for (int i = 1; i < 2 * nums.length; i++) {
            if (nums[i] <= nums[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                    res[stack.peek()] = nums[i % nums.length];
                    stack.pop();
                }
                stack.push(i % nums.length);
            }

        }
        return res;

    }
}
