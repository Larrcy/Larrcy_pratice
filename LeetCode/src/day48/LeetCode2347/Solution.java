package day48.LeetCode2347;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }
    public int edgeScore(int[] edges) {
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i]).add(i);
        }
        int res = -1;
        long max = 0;
        for (int i = 0; i < graph.size(); i++) {
            long sum = 0;
            for (int j = 0; j < graph.get(i).size(); j++) {
                sum += graph.get(edges[i]).get(j);
            }
            if (sum > max) {
                res = i;
                max = sum;
            }
        }
        return res;
    }
}
