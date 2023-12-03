package day64.贪心.LeetCode1578;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Alice 把 n 个气球排列在一根绳子上。给你一个下标从 0 开始的字符串 colors ，其中 colors[i] 是第 i 个气球的颜色。
 * <p>
 * Alice 想要把绳子装扮成 彩色 ，且她不希望两个连续的气球涂着相同的颜色，所以她喊来 Bob 帮忙。Bob 可以从绳子上移除一些气球使绳子变成 彩色 。给你一个下标从 0 开始的整数数组 neededTime ，其中 neededTime[i] 是 Bob 从绳子上移除第 i 个气球需要的时间（以秒为单位）。
 * <p>
 * 返回 Bob 使绳子变成 彩色 需要的 最少时间 。
 */
public class Solution {
    public int minCost(String colors, int[] neededTime) {
        if (colors.length() == 1) return 0;
        int res = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(neededTime[0]);
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                deque.add(neededTime[i]);
                if (deque.getFirst() < deque.getLast()) {
                    res += deque.getFirst();
                    deque.pollFirst();
                } else {
                    res += deque.getLast();
                    deque.pollLast();
                }
            } else {
                deque.clear();
                deque.add(neededTime[i]);
            }
        }
        return res;
    }
}
