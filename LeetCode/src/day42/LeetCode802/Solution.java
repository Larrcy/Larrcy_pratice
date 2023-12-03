package day42.LeetCode802;

import java.util.*;

public class Solution {
    //深度优先遍历+三色标记法
    //本题需要求解所有不在环内的节点将其存入集合并按照大小排序
    //标记规则
    //0->白色 该节点尚未被访问
    //1->灰色 该节点位于递归栈中或在某个环上
    //2->黑色 该节点搜索完毕为安全节点
    //若我们首次访问一个节点 则将其标记为灰色 并继续搜索与其相邻节点
    //若我们在搜索过程中遇到了灰色节点 说明遇到了环 此时退出搜索
    //若没有遇到灰色节点则说明没有遇到环 则在递归返回前将其标记为黑色
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // 存储结果集
        List<Integer> resultList = new ArrayList<>();

        int n = graph.length;

        // 0表示未访问过，1表示访问中，2表示是安全点
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            // 如果从当前节点出发是安全的，则加入结果集中
            if (safe(graph, i, visited)) {
                resultList.add(i);
            }
        }

        return resultList;
    }

    private boolean safe(int[][] graph, int index, int[] visited) {
        if (visited[index] != 0) {
            // 不是0，说明被访问过，判断是否为2
            return visited[index] == 2;
        }

        // 说明未被访问过，设置为访问中
        visited[index] = 1;
        for (int next : graph[index]) {
            // DFS过程中再次遇到相同的节点，说明有环，即为不安全，直接返回false
            if (!safe(graph, next, visited)) {
                return false;
            }
        }

        // 下游节点全部遍历完成，都是安全的，说明当前节点安全，返回true
        visited[index] = 2;
        return true;
    }

}
