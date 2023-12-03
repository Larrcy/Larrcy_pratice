package day47.LeetCode1381;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack;
    Stack<Integer> stackOut;

    int maxSize = 0;
    int size = 0;

    public void CustomStack(int maxSize) {
        stack = new Stack<>();
        stackOut = new Stack<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (size < maxSize) {
            stack.push(x);
            size++;
        }

    }

    public int pop() {
        if (!stack.isEmpty() && size > 0) {
            size--;
            return stack.pop();

        } else return -1;
    }

    public void increment(int k, int val) {
        while (!stack.isEmpty()) {
            stackOut.push(stack.pop());
        }
        if (stackOut.size() < k) {
            while (!stackOut.isEmpty()) {
                stack.push(stackOut.pop() + val);
            }
        } else {
            while (!stackOut.isEmpty()) {
                if (k > 0) {
                    k--;
                    stack.push(stackOut.pop() + val);

                } else {
                    stack.push(stackOut.pop());
                }
            }

        }

    }
}
