package day50.LeetCode1575;

import java.util.Arrays;

public class Solution {
    int mod = 1000000007;

    // 缓存器：用于记录「特定状态」下的结果
    // cache[i][fuel] 代表从位置 i 出发，当前剩余的油量为 fuel 的前提下，到达目标位置的「路径数量」
    int[][] cache;

    public int countRoutes(int[] ls, int start, int end, int fuel) {
        int n = ls.length;

        // 初始化缓存器
        // 之所以要初始化为 -1
        // 是为了区分「某个状态下路径数量为 0」和「某个状态尚未没计算过」两种情况
        cache = new int[n][fuel + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cache[i], -1);
        }

        return dfs(ls, start, end, fuel);
    }

    /**
     * 计算「路径数量」
     * @param ls 入参 locations
     * @param u 当前所在位置（ls 的下标）
     * @param end 目标哦位置（ls 的下标）
     * @param fuel 剩余油量
     * @return 在位置 u 出发，油量为 fuel 的前提下，到达 end 的「路径数量」
     */
    int dfs(int[] ls, int u, int end, int fuel) {
        // 如果缓存器中已经有答案，直接返回
        if (cache[u][fuel] != -1) {
            return cache[u][fuel];
        }

        int n = ls.length;
        // base case 1：如果油量为 0，且不在目标位置
        // 将结果 0 写入缓存器并返回
        if (fuel == 0 && u != end) {
            cache[u][fuel] = 0;
            return 0;
        }

        // base case 2：油量不为 0，且无法到达任何位置
        // 将结果 0 写入缓存器并返回
        boolean hasNext = false;
        for (int i = 0; i < n; i++) {
            if (i != u) {
                int need = Math.abs(ls[u] - ls[i]);
                if (fuel >= need) {
                    hasNext = true;
                    break;
                }
            }
        }
        if (fuel != 0 && !hasNext) {
            cache[u][fuel] = u == end ? 1 : 0;
            return cache[u][fuel];
        }

        // 计算油量为 fuel，从位置 u 到 end 的路径数量
        // 由于每个点都可以经过多次，如果 u = end，那么本身就算一条路径
        int sum = u == end ? 1 : 0;
        for (int i = 0; i < n; i++) {
            if (i != u) {
                int need = Math.abs(ls[i] - ls[u]);
                if (fuel >= need) {
                    sum += dfs(ls, i, end, fuel - need);
                    sum %= mod;
                }
            }
        }
        cache[u][fuel] = sum;
        return sum;
    }

}
