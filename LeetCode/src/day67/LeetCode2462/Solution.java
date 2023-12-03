package day67.LeetCode2462;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。

 同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：

 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 一位工人只能被选择一次。
 返回雇佣恰好 k 位工人的总代价。


 */
public class Solution {

    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        if (costs.length - k < candidates * 2) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                res += costs[i];
            }
            return res;
        }
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < candidates; i++) {
            queue1.add(costs[i]);
        }
        for (int i = candidates; i < costs.length - candidates; i++) {
            deque.add(costs[i]);
        }
        for (int i = costs.length - candidates; i < costs.length; i++) {
            queue2.add(costs[i]);
        }
        int count = 0;
        while (count < k) {
            if (queue1.peek() <= queue2.peek()) {
                res += queue1.poll();
                queue1.add(deque.pollFirst());
            } else {
                res += queue2.poll();
                queue2.add(deque.pollLast());
            }
            count++;
        }
        return res;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
