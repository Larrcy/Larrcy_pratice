package 模板.多源最短路;

import java.util.Arrays;

/**
 * 给你两个下标从 0 开始的字符串 source 和 target ，它们的长度均为 n 并且由 小写 英文字母组成。
 * <p>
 * 另给你两个下标从 0 开始的字符数组 original 和 changed ，以及一个整数数组 cost ，其中 cost[i] 代表将字符 original[i] 更改为字符 changed[i] 的成本。
 * <p>
 * 你从字符串 source 开始。在一次操作中，如果 存在 任意 下标 j 满足 cost[j] == z  、original[j] == x 以及 changed[j] == y 。你就可以选择字符串中的一个字符 x 并以 z 的成本将其更改为字符 y 。
 * <p>
 * 返回将字符串 source 转换为字符串 target 所需的 最小 成本。如果不可能完成转换，则返回 -1 。
 * <p>
 * 注意，可能存在下标 i 、j 使得 original[j] == original[i] 且 changed[j] == changed[i]
 */
public class Solution {
    //将所有路径初始化为无穷
    private static final long inf = Integer.MAX_VALUE;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        //该题只有小写字母故初始化成26的即可
        long[][] dis = new long[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dis[i], inf);
            //自己到自己的路径初始化为0
            dis[i][i] = 0;
        }
        int n = original.length;
        for (int i = 0; i < n; i++) {
            //相同路径取权值最小的
            int x = original[i] - 'a', y = changed[i] - 'a';
            dis[x][y] = Math.min(dis[x][y], cost[i]);
        }
        //Floyd算法
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        long ans = 0;
        int m = source.length();
        for (int i = 0; i < m; i++) {
            //查找路径长度若不为无穷则收集结果
            long cur = dis[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            if (cur == inf) return -1;
            ans += cur;
        }
        return ans;
    }
}
