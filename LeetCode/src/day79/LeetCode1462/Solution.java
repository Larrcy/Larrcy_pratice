package day79.LeetCode1462;

import java.util.*;

public class Solution {
    List<Integer>[] build(int n, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for (int[] edge : prerequisites) {
            int x = edge[0];
            int y = edge[1];
            graph[x].add(y);
        }
        return graph;
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = build(numCourses, prerequisites);
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int x = edge[0];
            int y = edge[1];
            indegree[y]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.add(i);
        }
        boolean[][] isPre = new boolean[numCourses][numCourses];
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (Integer neighbor : graph[cur]) {
                isPre[cur][neighbor] = true;
                for (int i = 0; i < numCourses; i++) {
                    isPre[i][neighbor] |= isPre[i][cur];
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] edge : queries) {
            res.add(isPre[edge[0]][edge[1]]);
        }
        return res;


    }
}
