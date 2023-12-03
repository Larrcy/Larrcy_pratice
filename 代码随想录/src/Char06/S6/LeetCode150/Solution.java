package Char06.S6.LeetCode150;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList();
        for (String s : tokens) {

            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());      // 注意 - 和/ 需要特殊处理
            } else if ("-".equals(s)) {
                int p1 = stack.pop();
                int p2 = stack.pop();
                stack.push(p2 - p1);
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                //栈是先进后出 计算时是从左到右
                //所以被除数会在栈底
                stack.push(temp2 / temp1);
            } else {
                //遇见数字则直接加入到栈中
                stack.push(Integer.valueOf(s));
            }
        }
        //最后返回栈中所剩最后一个元素
        return stack.pop();
    }
}
