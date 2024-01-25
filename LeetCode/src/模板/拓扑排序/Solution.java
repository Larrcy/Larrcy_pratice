package 模板.拓扑排序;

import java.util.*;

public class Solution {
    //拓扑排序建立有向图 可以判断有无环
    //考虑正向建图和反向建图
    //拓扑排序要统计所有点的入度
    //若删除到最后所有点的入度不为0则有环
    List<Integer>[] build(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : prerequisites) {
            int x = e[0], y = e[1];
            g[y].add(x);
        }
        return g;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = build(numCourses, prerequisites);
        //建立入度数组
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int to = edge[0];
            indegree[to]++;
        }
        //将入度为0的点入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        //统计遍历到的节点
        int count = 0;
        //bfs框架
        while (!queue.isEmpty()) {
            // 弹出节点 cur，并将它指向的节点的入度减一
            int cur = queue.poll();
            count++;
            for (Integer neighbor : graph[cur]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        //若有环则无法遍历到所有的节点
        return count == numCourses;

    }
}
