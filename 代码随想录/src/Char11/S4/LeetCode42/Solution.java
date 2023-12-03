package Char11.S4.LeetCode42;

import java.util.Stack;

public class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= height[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    //记录中间元素 并将其弹出
                    int mid = stack.peek();
                    stack.pop();
                    if (!stack.isEmpty()) {
                        int h = Math.min(height[i], height[stack.peek()])-height[mid];
                        int w = i - stack.peek() - 1;
                        sum += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return sum;
    }
}
