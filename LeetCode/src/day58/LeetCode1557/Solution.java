package day58.LeetCode1557;

import java.util.*;

public class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            indegree[to]++;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
