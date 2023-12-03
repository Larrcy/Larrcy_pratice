package Char12.S1.LeetCode797;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //添加0号节点
        path.add(0);
        dfs(graph, 0);
        return res;
    }

    public void dfs(int[][] graph, int node) {
        //当节点为n-1保存该路径
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[node].length; i++) {
            int nexNode = graph[node][i];
            path.add(nexNode);
            dfs(graph, nexNode);
            path.remove(path.size() - 1);
        }
    }
}
