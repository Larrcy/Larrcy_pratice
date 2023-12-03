package day61.LeetCode155;

import java.util.Stack;

public class Solution {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> Minstack = new Stack<>();

    public void MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (Minstack.isEmpty()) {
            Minstack.push(val);
        } else {
            if (Minstack.peek() < val) {
                Minstack.push(Minstack.peek());
            } else Minstack.push(val);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) stack.pop();
        if (!Minstack.isEmpty()) Minstack.pop();
    }

    public int top() {
        if (!stack.isEmpty()) return stack.peek();
        else return -1;
    }

    public int getMin() {
        if (!Minstack.isEmpty()) return Minstack.peek();
        else return -1;
    }
}
