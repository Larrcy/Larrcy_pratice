package day81.LeetCode878;


import java.util.Arrays;

/**
 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。

 你可以对数组执行 至多 k 次操作：

 从数组中选择一个下标 i ，将 nums[i] 增加 或者 减少 1 。
 最终数组的频率分数定义为数组中众数的 频率 。

 请你返回你可以得到的 最大 频率分数。

 众数指的是数组中出现次数最多的数。一个元素的频率指的是数组中这个元素的出现次数。*/
public class Solution {
    public int minMalwareSpread(int[][] mat, int[] initial) {
        //先对initial从小到大排序方便判断
        Arrays.sort(initial);
        int N = mat.length;
        UF uf = new UF(N);
        //构建联通分量
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        int[] count = new int[N];
        //计算每个联通分量的感染个数
        for (int i : initial) {
            count[uf.find(i)]++;
        }
        // 连通分量的大小
        int maxCCSize = Integer.MIN_VALUE;
        int index = initial[0];
        for (int i : initial) {
            int root = uf.find(i);
            //联通分量的感染节点数大于1则该联通分量无法恢复正常
            //连通分量的感染节点为 1， 去掉该节点后，最后该连通分量全部正常
            //记录该部分联通分量的大小
            if (count[root] == 1 && uf.size[root] > maxCCSize) {
                maxCCSize = uf.size[root];
                index = i;
            }
        }
        return index;
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
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;
        ListNode pre = null;
        cur = head;
        while (n >= k) {
            n -= k;
            for (int i = 0; i < k; i++) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummy.next;
    }

    boolean isValid(int[] cnt1, int[] cnt2) {
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) return false;
        }
        return true;
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














