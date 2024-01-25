package day80.LeetCode130;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 */
public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // 多一个节点用来存放 dummy用来解决外围不能被覆盖的O
        //m*n用来将二维转换成一维
        UF uf = new UF(m * n + 1);
        int dummy = m * n;
        // 将 dummy 和四条边的所有 'O' 相连
        for (int i = 0; i < m; i++) {
            //[i][j]-->n*i+j
            if (board[i][0] == 'O') uf.union(dummy, i * n);
            if (board[i][n - 1] == 'O') uf.union(dummy, i * n + n - 1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') uf.union(dummy, j);
            if (board[m - 1][j] == 'O') uf.union(dummy, (m - 1) * n + j);
        }
        // 将内圈的所有相邻的 'O' 全部连起来
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int[] d : dirs) {
                        int newI = i + d[0];
                        int newJ = j + d[1];
                        if (board[newI][newJ] == 'O') {
                            uf.union(i * n + j, newI * n + newJ);
                        }
                    }
                }
            }
        }
        //遍历数组找出所有与dummy不连通的O将其改成X
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !uf.connected(dummy, i * n + j)) board[i][j] = 'X';
            }
        }
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
            if (rootP == rootQ) return ;
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
