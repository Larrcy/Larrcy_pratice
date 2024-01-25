package day78.LeetCode239;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    class MyQue {
        Deque<Integer> deque = new ArrayDeque<>();

        void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(val);
        }

        void poll(int val) {
            if (!deque.isEmpty() && val == deque.peek()) {
                deque.removeFirst();
            }
        }

        int peek() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int len = n - k + 1;
        int[] res = new int[len];
        MyQue que = new MyQue();
        for (int i = 0; i < k; i++) {
            que.add(nums[i]);

        }
        res[0] = que.peek();
        for (int i = k; i < n; i++) {
            que.poll(nums[i - k]);
            que.add(nums[i]);
            res[i - k + 1] = que.peek();
        }
        return res;
    }
}
