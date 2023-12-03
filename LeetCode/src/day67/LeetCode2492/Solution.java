package day67.LeetCode2492;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 给你一个正整数 n ，表示总共有 n 个城市，城市从 1 到 n 编号。给你一个二维数组 roads ，其中 roads[i] = [ai, bi, distancei] 表示城市 ai 和 bi 之间有一条 双向 道路，道路距离为 distancei 。城市构成的图不一定是连通的。

 两个城市之间一条路径的 分数 定义为这条路径中道路的 最小 距离。

 城市 1 和城市 n 之间的所有路径的 最小 分数。

 注意：

 一条路径指的是两个城市之间的道路序列。
 一条路径可以 多次 包含同一条道路，你也可以沿着路径多次到达城市 1 和城市 n 。
 测试数据保证城市 1 和城市n 之间 至少 有一条路径。
 */
public class Solution {
    //连通块内的最小边权--bfs
    public int minScore(int n, int[][] roads) {
        int ans = Integer.MAX_VALUE, min = ans;
        List<int[]>[] adjs = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adjs[i] = new ArrayList<>();
        for (int[] road : roads) {
            //添加道路关联的信息和权值
            adjs[road[0]].add(new int[]{road[1], road[2]});
            adjs[road[1]].add(new int[]{road[0], road[2]});
            min = Math.min(min, road[2]);
        }
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        vis[1] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] next : adjs[cur]) {
                ans = Math.min(ans, next[1]); // 先判断当前边的距离（确保每一条边都能遍历到）
                if (vis[next[0]]) continue; // 再判断是否已经添加到队列
                queue.offer(next[0]);
                vis[next[0]] = true;
            }
        }
        return ans;
    }
}
