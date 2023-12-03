package day43.LeetCode2368;

import java.util.*;

public class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        /*
        bfs搜索
         */
        // 建图
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        boolean[] visit = new boolean[n];
        for (int num : restricted) visit[num] = true;
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        visit[0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            for (int next : list.get(cur)) {
                if (!visit[next]) {
                    queue.addLast(next);
                    visit[next] = true;
                    ++ans;
                }
            }
        }
        return ans;
    }
}

