package day77.LeetCode2477;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
 * <p>
 * 每个城市里有一个代表，他们都要去首都参加一个会议。
 * <p>
 * 每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
 * <p>
 * 城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
 * <p>
 * 请你返回到达首都最少需要多少升汽油。
 */
public class Solution {
    //将0看作是根节点
    //转换成以0为根节点的一棵树
    //相当于从所有的叶子节点到根节点需要的最少耗费
    //由于每个节点都有一辆车
    //因此从根节点出发每个人都有一辆车
    //为了使耗费最少 当某辆车的座位没有坐满人时 我们让其坐满人
    //故每颗子树的消耗为 ceil(sum(节点个数)/座位数)上取整是为了让多余的那个人也坐上车
    //故总消耗为sum(ceil(sum(节点个数)/座位数))
    long ans = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        //节点个数
        int n = roads.length + 1;
        //建图
        List<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : roads) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
            graph[to].add(from);
        }
        dfs(0, -1, graph, seats);
        return ans;

    }

    int dfs(int cur, int fa, List<Integer>[] graph, int seats) {
        int size = 1;
        for (int y : graph[cur]) {
            if (y != fa) { // 递归子节点，不能递归父节点
                size += dfs(y, cur, graph, seats); // 计算子树大小
            }
        }
        if (cur > 0) { //  当前节点不是根节点的时候收集结果
            ans += Math.ceil((double) size / seats);
        }
        return size;
    }


}
