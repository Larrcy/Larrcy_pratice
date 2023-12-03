package Char11.S1.LeetCode739;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        stack.push(0);
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                  //最后将没弹出栈的元素全部弹出并记录结果
                    res[stack.peek()] = i - stack.peek();
                    //栈顶元素已使用 将其弹出
                    stack.pop();
                }
                stack.push(i);
            }

        }
        return res;
    }
}
