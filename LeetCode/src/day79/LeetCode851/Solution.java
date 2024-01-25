package day79.LeetCode851;

import 基础算法.Graph;

import java.util.*;

public class Solution {
    List<Integer>[] build(int[][] richer, int n) {
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for (int[] edge : richer) {
            int x = edge[0];
            int y = edge[1];
            graph[x].add(y);
        }
        return graph;
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {

        int n = quiet.length;
        List<Integer>[] graph = build(richer, n);
        int[] indegree = new int[n];
        for (int[] edge : richer) {
            indegree[edge[1]]++;
        }
        int[] ans = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            ans[i] = i;
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            for (Integer neighbor : graph[cur]) {
                //取更新后的值进行比较
                if (quiet[ans[cur]] < quiet[ans[neighbor]]) {
                    ans[neighbor] = ans[cur];
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return ans;
    }
}
