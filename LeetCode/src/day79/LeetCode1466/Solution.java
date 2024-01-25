package day79.LeetCode1466;

import java.util.*;

/**
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 *
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 *
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 *
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 *
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 *
 *
 */
public class Solution {
    //建双向图 同时存储0->1的权值为1 1->0的权值为0
    //这样就可以统计反向边的个数
    //所有的反向边相加即为结果
    List<Integer[]>[] build(int n, int[][] richer) {
        List<Integer[]>[] graph = new List[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for (int[] edge : richer) {
            int x = edge[0];
            int y = edge[1];
            graph[x].add(new Integer[]{y, 1});
            graph[y].add(new Integer[]{x, 0});
        }
        return graph;
    }

    public int minReorder(int n, int[][] connections) {
        List<Integer[]>[] graph = build(n, connections);
        boolean[] visit = new boolean[n];
        Deque<Integer> que = new ArrayDeque<>();
        //首先添加进0节点
        que.offer(0);
        visit[0] = true;
        int ans = 0;
        while (!que.isEmpty()) {
            Integer cur = que.poll();
            for (Integer[] neighbor : graph[cur]) {
                //访问过的节点直接跳过
                if (visit[neighbor[0]]) {
                    continue;
                }
                //标记未访问的节点
                visit[neighbor[0]] = true;
                //记录反向边的权值
                ans += neighbor[1];
                //将节点添加进队列
                que.add(neighbor[0]);
            }
        }
        return ans;

    }
}
