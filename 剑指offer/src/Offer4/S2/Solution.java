package Offer4.S2;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    //模拟包含min函数的栈
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public void MinStack() {
        //用一个额外的栈进行模拟
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        //首先在最小栈里存入一个max
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        //压入操作根x栈进行取最小值
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        //出栈操作与普通栈一样
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        //top为x的栈顶
        return xStack.peek();
    }

    public int min() {
        //最小值就是最小栈的栈顶
        return minStack.peek();
    }
}
