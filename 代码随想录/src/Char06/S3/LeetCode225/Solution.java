package Char06.S3.LeetCode225;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {


    //使用一个队列实现栈
    Queue<Integer> queue;

    public void MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        rePosition();
        return queue.poll();
    }

    public int top() {
        rePosition();
        int result = queue.poll();
        queue.add(result);
        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    //一个队列在模拟栈弹出元素的时候只要将队列头部的元素（除了最后一个元素外）
    //重新添加到队列尾部，此时再去弹出元素就是栈的顺序了。
    public void rePosition() {
        int size = queue.size();
        while (size-- > 1)
            queue.add(queue.poll());
    }
}
