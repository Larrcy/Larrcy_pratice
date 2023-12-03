package day14.LeetCode232;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

    }
        //创建入栈和出栈来实现队列的操作
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /**
     * Initialize your data structure here.
     */
    public void MyQueue() {
        stackIn = new Stack<>(); // 负责进栈
        stackOut = new Stack<>(); // 负责出栈
    }

    /**
     * Push element x to the back of queue.
     */
    //元素进入队列
    public void push(int x) {
        //直接将元素放入入栈
        stackIn.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    //元素弹出队列
    public int pop() {
        //要先将入栈的所有元素放入到出栈里
        //再从出栈里依次出栈才可以保证队列先进先出的特性
        dumpstackIn();
        return stackOut.pop();
    }

    /**
     * Get the front element.
     */
    //获取队列出口处第一个元素
    public int peek() {
        dumpstackIn();
        return stackOut.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
    private void dumpstackIn() {
        if (!stackOut.isEmpty()) return;
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
