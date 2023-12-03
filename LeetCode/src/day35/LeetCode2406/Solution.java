package day35.LeetCode2406;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int minGroups(int[][] intervals) {
        //最小堆模拟
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        //如果当前的 left 大于堆顶，则可以接在这个组的末尾，更新堆顶为 right；
        //否则需要创建一个新的组。
        for (int[] p : intervals) {
            if (!pq.isEmpty() && pq.peek() < p[0]) pq.poll();
            pq.offer(p[1]);
        }
        return pq.size();
    }


}
