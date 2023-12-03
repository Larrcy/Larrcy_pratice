package day29.LeetCode946;

import java.util.*;
public class Solution {
    //用栈进行模拟 若入栈的元素与popped中栈顶元素相同则出栈
    //栈为空则返回true 不为空则返回false
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0, j = 0; i < len; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
