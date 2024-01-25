package day83.LeetCode1319;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        UF uf = new UF(n);
        //如果两个点连通那么将这两个点压缩成一个点
        //最后剩下的点一定是不连通的
        //而不连通的点需要count-1条边
        for (int[] connection : connections) {
            uf.union(connection[0], connection[1]);
        }
        return uf.count - 1;
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
