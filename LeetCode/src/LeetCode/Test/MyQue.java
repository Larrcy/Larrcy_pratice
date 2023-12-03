package LeetCode.Test;

import java.util.ArrayDeque;
import java.util.Deque;


class MyQue {
    Deque<Integer> deque = new ArrayDeque<>();

    void poll(int val) {
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }

    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    int peek() {
        return deque.peek();
    }
}
