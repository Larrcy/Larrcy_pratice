package day78.LeetCode2925;
import java.util.*;

/**
 * 有一棵 n 个节点的无向树，节点编号为 0 到 n - 1 ，根节点编号为 0 。给你一个长度为 n - 1 的二维整数数组 edges 表示这棵树，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 有一条边。
 *
 * 同时给你一个长度为 n 下标从 0 开始的整数数组 values ，其中 values[i] 表示第 i 个节点的值。
 *
 * 一开始你的分数为 0 ，每次操作中，你将执行：
 *
 * 选择节点 i 。
 * 将 values[i] 加入你的分数。
 * 将 values[i] 变为 0 。
 * 如果从根节点出发，到任意叶子节点经过的路径上的节点值之和都不等于 0 ，那么我们称这棵树是 健康的 。
 *
 * 你可以对这棵树执行任意次操作，但要求执行完所有操作以后树是 健康的 ，请你返回你可以获得的 最大分数 。
 */
public class Solution {
    //该问题可以抽象成从树中选一些节点的值之后将节点的值变成0
    //保证树中每条路径的值都大于0的情况下能获取的最大值
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        List<Integer>[] g = new ArrayList[values.length];
        Arrays.setAll(g, e -> new ArrayList<>());
        g[0].add(-1); // 避免误把根节点当作叶子
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        // 先把所有分数加入答案
        long ans = 0;
        for (int v : values) {
            ans += v;
        }
        return ans - dfs(0, -1, g, values);
    }
    // dfs(x) 计算以 x 为根的子树是健康时，失去的最小分数
    private long dfs(int x, int fa, List<Integer>[] g, int[] values) {
        //g[x].size() == 1表示x的邻居节点只有一个特殊处理完根节点后 x必定为叶子节点
        if (g[x].size() == 1) {
            return values[x];
        }
        //分两种情况讨论
        //1.不根节点 此时损失的分数只有根节点的分数
        //2.选根节点 那么将继续判断子树的根节点选不选
        //下面是第二种情况
        long loss = 0;
        for (int y : g[x]) {
            if (y != fa) {
                loss += dfs(y, x, g, values); // 计算以 y 为根的子树是健康时，失去的最小分数
            }
        }
        return Math.min(values[x], loss); // 两种情况取最小值
    }


}
