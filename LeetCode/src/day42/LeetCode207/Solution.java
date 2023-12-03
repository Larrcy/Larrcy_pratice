package day42.LeetCode207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> new_graph = new ArrayList<List<Integer>>();
        // 节点入度
        int[] Indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            new_graph.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            Indeg[cp[0]]++;
            new_graph.get(cp[1]).add(cp[0]);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        // 首先将入度为 0 的点存入队列
        for (int i = 0; i < numCourses; i++) {
            if (Indeg[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            // 每次弹出队头元素
            int cur = q.poll();
            for (int x : new_graph.get(cur)) {
                // 将以其为起点的有向边删除，更新终点入度
                Indeg[x]--;
                if (Indeg[x] == 0) q.offer(x);
            }
        }

        // 最终入度（原图中出度）为 0 的所有点均为安全点
        for (int i = 0; i < numCourses; i++) {
            if (Indeg[i] != 0) return false;
        }
        return true;
    }

}

