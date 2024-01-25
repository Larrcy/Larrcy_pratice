package day81.LeetCode1559;


/**
 给你一个二维字符网格数组 grid ，大小为 m x n ，你需要检查 grid 中是否存在 相同值 形成的环。

 一个环是一条开始和结束于同一个格子的长度 大于等于 4 的路径。对于一个给定的格子，你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这两个格子有 相同的值 。

 同时，你也不能回到上一次移动时所在的格子。比方说，环  (1, 1) -> (1, 2) -> (1, 1) 是不合法的，因为从 (1, 2) 移动到 (1, 1) 回到了上一次移动时的格子。

 如果 grid 中有相同值形成的环，请你返回 true ，否则返回 false 。
 */
public class Solution {
    int m;
    int n;

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        UF uf = new UF(m * n);
        //判断有无环只需要往右下遍历
        int[][] dirs = new int[][]{{1, 0}, {0, 1}};
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int[] d : dirs) {
                    int newI = i + d[0];
                    int newJ = j + d[1];
                    if (!inArea(newI, newJ)) continue;
                    if (grid[i][j] == grid[newI][newJ]) {
                        if (uf.find(i * n + j) == uf.find(newI * n + newJ)) {
                            return true;
                        } else {
                            uf.union(i * n + j, newI * n + newJ);
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    //并查集用来解决连通块的问题
    class UF {
        private int count;
        private int[] parent;
        private int[] size;

        public UF(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                //如果自己就是根节点，那么parent[i] = i，即自己指向自己
                //最初的每个节点都是独立的
                parent[i] = i;
                size[i] = 1;
            }
        }

        /* 将 p 和 q 连接 */
        public void union(int p, int q) {
            // 找到 p 的根节点 rootP
            // 找到 q 的根节点 rootQ
            int rootP = find(p);
            int rootQ = find(q);
            // 如果已经在同一个连通分中，跳过
            if (rootP == rootQ) return;
            // 平衡性优化
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            } else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            this.count--;
        }

        /* 判断 p 和 q 是否连通 */
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }

        /* 返回图中有多少个连通分量 */
        public int count() {
            return this.count;
        }

        /* 返回当前节点的根节点 */
        private int find(int x) {
            // 路径压缩
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

    }

}

















