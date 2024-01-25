package 模板.建图;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //邻接表建无向图
    public List<Integer>[] build(int[][] edges, int[] values) {
        List<Integer>[] g = new ArrayList[values.length];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        return g;
    }

}
