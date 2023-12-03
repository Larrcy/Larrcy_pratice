package 基础算法;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    //分别设置顶点和边
    private int V;
    private int E;
    //设置邻接表
    private Queue<Integer>[] adj;


    //初始化图
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    //获取顶点和边
    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    //向无向图中添加一条边
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    //获取顶点v相邻的所有顶点
    public Queue<Integer> adj(int v) {
        return adj[v];
    }
}
