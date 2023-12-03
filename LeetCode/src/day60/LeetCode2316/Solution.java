package day60.LeetCode2316;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数 n ，表示一张 无向图 中有 n 个节点，编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。
 * <p>
 * 请你返回 无法互相到达 的不同 点对数目 。
 */
public class Solution {
    /**
     * 设当前连通块的大小为 size，那么这个连通块中的每个点，
     * 与前面遍历过的连通块的每个点，都是无法互相到达的，
     * 根据乘法原理，有 size⋅totale⋅个，累加到答案中
     *

     * @param n
     * @param edges
     * @return
     */
    public long countPairs(int n, int[][] edges) {
        // 建无向图
        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
            graph[to].add(from);
        }
        boolean[] vis = new boolean[n];
        long ans = 0;
        for (int i = 0, total = 0; i < n; i++) {
            if (!vis[i]) { // 未访问的点：说明找到了一个新的连通块
                int size = dfs(i,graph, vis);
                ans += (long) size * total;
                //total用于维护之前连通块的大小之和
                total += size;
            }
        }
        return ans;

    }
    private int dfs(int x, List<Integer>[] g, boolean[] vis) {
        vis[x] = true; // 避免重复访问同一个点
        int size = 1;
        //统计整个连通块的大小(即连通块有多少点)
        for (int y : g[x]) {
            if (!vis[y]) {
                size += dfs(y, g, vis);
            }
        }
        return size;
    }

}
