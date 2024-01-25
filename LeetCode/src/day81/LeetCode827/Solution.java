package day81.LeetCode827;


import java.util.HashSet;
import java.util.Set;

/**
 给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。

 返回执行此操作后，grid 中最大的岛屿面积是多少？

 岛屿 由一组上、下、左、右四个方向相连的 1 形成。
 */
public class Solution {
    int m;
    int n;

    public int largestIsland(int[][] board) {
        m = board.length;
        n = board[0].length;
        //m*n用来将二维转换成一维
        UF uf = new UF(m * n + 1);
        int res = 0;
        //将当前点的右方和下方做连通
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    if ((i + 1) < m && board[i + 1][j] == 1) {
                        uf.union((i + 1) * n + j, i * n + j);
                    }
                    if ((j + 1) < n && board[i][j + 1] == 1) {
                        uf.union(i * n + (j + 1), i * n + j);
                    }
                }
            }
        }


        //再次遍历board 将其中的一个0改为1
        //并观察该点的上下左右4个方向是否有不同的联通区域
        //若有则将答案累加
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    Set<Integer> rootSet = new HashSet<>();
                    int tmp = 1;//此点位0，改变其为1，陆地面积+1
                    for (int[] dir : dirs) {
                        int nextI = i + dir[0], nextJ = j + dir[1];//当前点的下一个点，四个方向
                        if (!inArea(nextI, nextJ)) continue;
                        int rootIdx = uf.find(nextI * n + nextJ);//找到当前点的共同父节点
                        if (board[nextI][nextJ] == 1 && !rootSet.contains(rootIdx)) {//此父节点未被访问过
                            tmp += uf.size[rootIdx];
                            rootSet.add(rootIdx);
                        }
                    }
                    res = Math.max(res, tmp);//取最大值
                }

            }
        }
        return res==0?m*n:res;

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

















