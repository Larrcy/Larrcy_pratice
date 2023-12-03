package day67.LeetCode2497;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 给你一个 n 个点的无向图，节点从 0 到 n - 1 编号。给你一个长度为 n 下标从 0 开始的整数数组 vals ，其中 vals[i] 表示第 i 个节点的值。

 同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条双向边。

 星图 是给定图中的一个子图，它包含一个中心节点和 0 个或更多个邻居。换言之，星图是给定图中一个边的子集，且这些边都有一个公共节点。

 下图分别展示了有 3 个和 4 个邻居的星图，蓝色节点为中心节点。
 */
class Solution {
    public static int maxStarSum(int[] vals, int[][] edges, int k) {
        //建图
        List<Integer>[] g = new List[vals.length];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        //找到k个正的节点然后计算最大的
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            if (vals[y] > 0) {
                g[x].add(vals[y]);
            }
            if (vals[x] > 0) {
                g[y].add(vals[x]);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < g.length; i++) {
            //将加进去的整数节点从大到小排序
            Collections.sort(g[i], Collections.reverseOrder()); // 也可以用快速选择
            //截取k个节点
            if (g[i].size() > k) {
                g[i] = g[i].subList(0, k);
            }
            int sum = vals[i];
            for (int v : g[i]) {
                sum += v;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
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
}
