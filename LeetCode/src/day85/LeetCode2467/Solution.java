package day85.LeetCode2467;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

/**
 * 一个 n 个节点的无向树，节点编号为 0 到 n - 1 ，树的根结点是 0 号节点。给你一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] ，表示节点 ai 和 bi 在树中有一条边。
 * <p>
 * 在每一个节点 i 处有一扇门。同时给你一个都是偶数的数组 amount ，其中 amount[i] 表示：
 * <p>
 * 如果 amount[i] 的值是负数，那么它表示打开节点 i 处门扣除的分数。
 * 如果 amount[i] 的值是正数，那么它表示打开节点 i 处门加上的分数。
 * 游戏按照如下规则进行：
 * <p>
 * 一开始，Alice 在节点 0 处，Bob 在节点 bob 处。
 * 每一秒钟，Alice 和 Bob 分别 移动到相邻的节点。Alice 朝着某个 叶子结点 移动，Bob 朝着节点 0 移动。
 * 对于他们之间路径上的 每一个 节点，Alice 和 Bob 要么打开门并扣分，要么打开门并加分。注意：
 * 如果门 已经打开 （被另一个人打开），不会有额外加分也不会扣分。
 * 如果 Alice 和 Bob 同时 到达一个节点，他们会共享这个节点的加分或者扣分。换言之，如果打开这扇门扣 c 分，那么 Alice 和 Bob 分别扣 c / 2 分。如果这扇门的加分为 c ，那么他们分别加 c / 2 分。
 * 如果 Alice 到达了一个叶子结点，她会停止移动。类似的，如果 Bob 到达了节点 0 ，他也会停止移动。注意这些事件互相 独立 ，不会影响另一方移动。
 * 请你返回 Alice 朝最优叶子结点移动的 最大 净得分。
 */
public class Solution {
    int[] bobTime;
    int[] amount;
    int res = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        //求出bob到0节点所需要的时间
        bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        this.amount = amount;
        //建树
        List<Integer>[] g  = new List[n];
        for(int i = 0; i < n; ++i) g[i] = new ArrayList<>();
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        //bob的路线固定 先dfs出 bob 的路线
        dfsBob(g, bob, -1,  0); //从bob点出发 走向0,  初始父节点为 -1

        g[0].add(-1); //防止0节点被误认为叶子节点
        dfsA(g, 0, -1, 0, 0); //寻找从0节点出发 到达叶子节点的最优路线
        return res;
    }

    public boolean dfsBob(List<Integer>[] g, int p, int f, int time) {
        //Bob走到0节点则说明Bob走完
        //time记录Bob走到某个节点所用的时间
        if (p == 0) {
            bobTime[p] = time;
            return true;
        }
        boolean flag = false;
        for (Integer child : g[p]) {
            if (child != f && dfsBob(g, child, p, time + 1)) {
                flag = true;
                break;
            }
        }
        if (flag) bobTime[p] = time;
        return flag;
    }

    public void dfsA(List<Integer>[] g, int p, int f, int time, int total) {
        //若Bob和Alice同时走到相同节点则amount[p] / 2
        if (bobTime[p] == time) {
            total += amount[p] / 2;

        }//若Bob未走过该节点则total += amount[p]
        else if (bobTime[p] > time) {
            total += amount[p];
        }
        //走到叶子节点则取最大值
        if (g[p].size() == 1) res = Math.max(res, total);
        for (Integer node : g[p]) {
            if (node != f) dfsA(g, node, p, time + 1, total);
        }
    }
}
