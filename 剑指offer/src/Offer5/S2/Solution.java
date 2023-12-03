package Offer5.S2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = pushed.length;
        //用两个栈来模拟栈的压入和弹出操作
        for (int i = 0, j = 0; i < n; i++) {
            //首先按照push数组进行压入操作
            stack.push(pushed[i]);
            //当栈顶元素等于j的元素时进行弹出操作
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

}
