package day42.LeetCode1466;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int n =6;
        int[][]connections={{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(minReorder(n, connections));
    }
    public static int minReorder(int n, int[][] connections) {
        //建图
        //遍历每个节点将每个节点到其相邻的节点记录下来
        //有向图
        //如0->1 1  0->4 0

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int[] c : connections) {
            graph.get(c[0]).add(new int[]{c[1], 1});
            graph.get(c[1]).add(new int[]{c[0], 0});
        }

        boolean[] visit = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visit[0] = true;
        int ans = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] x : graph.get(node)) {
                if (visit[x[0]]) {
                    continue;
                }
                visit[x[0]] = true;
                ans += x[1];
                queue.add(x[0]);
            }
        }
        return ans;
    }

}
