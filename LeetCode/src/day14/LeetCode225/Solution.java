package day14.LeetCode225;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }
    //使用一个队列实现栈
    Queue<Integer> queue;

    public void MyStack() {
        queue = new LinkedList<>();
    }

    //每 offer 一个数（A）进来，都重新排列，把这个数（A）放到队列的队首
    public void push(int x) {
        queue.offer(x);
        int size = queue.size();
        //移动除了A以外的前n个元素
        while (size-- > 1)
            queue.offer(queue.poll());
    }
        //移除栈顶元素
    public int pop() {
        //直接移除队列
        return queue.poll();
    }
        //返回栈顶元素
    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
