package day80.LeetCode1631;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 *
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 *
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 */
public class Solution {
    //对于4个方向上的问题一般不能用dp解决 需要用图论的知识
    //我们把每个格子当做图的一个节点，
    //把相邻两个格子的高度差绝对值当做边的权重。
    //就可以把输入的矩阵转化成为每条边都带有权重的图。
    //最小体力消耗值是该路径中的边的最大权重，即为 2。
    //可以先把图中的所有边都去掉，然后按照边的权重大小，把边再逐个的添加上
    //当我们添加到某一条边时，最左上角的节点和最右下角的节点连通了
    //那么该边的权重就是我们要求的最小体力消耗值。

    public int minimumEffortPath(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        List<int[]> edges = new ArrayList<>();
        //edges[i] 是个 [边的权重，边的第一个顶点，边的第二个顶点] 三元组
        //代码中的一个技巧就是把二维左边转成了一维，即第 i 行第 j 列映射成了 i * N + j。
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N) {
                    edges.add(new int[] {
                            Math.abs(mat[i][j + 1] - mat[i][j]),
                            i * N + j,
                            i * N + j + 1
                    });
                }
                if (i + 1 < M) {
                    edges.add(new int[] {
                            Math.abs(mat[i + 1][j] - mat[i][j]),
                            i * N + j,
                            (i + 1) * N + j
                    });
                }
            }
        }
        Collections.sort(edges, (o1, o2) -> o1[0] - o2[0]);

        UnionFind uf = new UnionFind(M * N);
        for (int[] edge : edges) {
            uf.union(edge[1], edge[2]);
            if (uf.find(0) == uf.find(M * N - 1)) {
                return edge[0];
            }
        }
        return 0;
    }

    class UnionFind {
        int count;      // 连通分量个数
        int[] parent;   // 节点i的父节点是parent[i]

        public UnionFind(int N) {
            this.count = N;         // n为图的节点总数
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;      // 父节点指针初始指向自己
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;          // x成为y的子树
            count--;
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }

}














