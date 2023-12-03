package day42.LeetCode802;
import java.util.*;
public class Solution2 {
    //拓扑排序
    //拓扑排序用于求图中入度为0的节点以及由入度为0的节点所指向的节点
    //本题恰好相反 为找出度为0的节点因此我们构造反图
    public static void main(String[] args) {
        int[][] graph={{1,2},{2,3},{5},{0},{5},{},{}};
        System.out.println(eventualSafeNodes(graph));
    }
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // 反图，邻接表存储
        List<List<Integer>> new_graph = new ArrayList<List<Integer>>();
        // 节点入度
        int[] Indeg = new int[n];

        for(int i = 0; i < n; i++) {
            new_graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                new_graph.get(graph[i][j]).add(i);
            }
            // 原数组记录的节点出度，在反图中就是入度
            Indeg[i] = graph[i].length;
        }

        // 拓扑排序
        Queue<Integer> q = new LinkedList<Integer>();

        // 首先将入度为 0 的点存入队列
        for(int i = 0; i < n; i++) {
            if(Indeg[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            // 每次弹出队头元素
            int cur = q.poll();
            for(int x : new_graph.get(cur)) {
                // 将以其为起点的有向边删除，更新终点入度
                Indeg[x]--;
                if(Indeg[x] == 0) q.offer(x);
            }
        }

        // 最终入度（原图中出度）为 0 的所有点均为安全点
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            if(Indeg[i] == 0) ret.add(i);
        }
        return ret;
    }
}
