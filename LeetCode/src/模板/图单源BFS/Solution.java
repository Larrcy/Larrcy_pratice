package 模板.图单源BFS;

public class Solution {
    int m;
    int n;
    public void f(int m, int n, int[][] board) {
       UF uf = new UF(m * n + 1);
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int[] d : dirs) {
                        int newI = i + d[0];
                        int newJ = j + d[1];
                        if (!inArea(newI, newJ)) continue;
                        if (board[newI][newJ] == 1) {
                            uf.union(i * n + j, newI * n + newJ);
                        }
                    }
                }
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
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

