package Offer4.S1;

import java.util.Stack;

public class Solution {
    Stack<Integer> A, B;

    public void CQueue() {
        A = new Stack<Integer>();
        B = new Stack<Integer>();
    }

    public void appendTail(int value) {
        A.add(value);
    }

    public int deleteHead() {
        if (!B.isEmpty()) return B.pop();
        if (A.isEmpty()) return -1;
        while (!A.isEmpty()) {
            B.push(A.pop());
        }
        return B.pop();
    }
}
