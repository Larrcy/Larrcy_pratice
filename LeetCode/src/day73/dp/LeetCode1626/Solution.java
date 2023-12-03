package day73.dp.LeetCode1626;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 * <p>
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 * <p>
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 */
public class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] envelopes = new int[scores.length][2];
        for (int i = 0; i < scores.length; i++) {
            envelopes[i][0] = ages[i];
            envelopes[i][1] = scores[i];
        }
        int n = envelopes.length;
        // 按宽度升序排列，如果年龄一样，则按分数升序排列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ?
                        a[1] - b[1] : a[0] - b[0];
            }
        });
        int[] dp = new int[n];
        dp[0] = envelopes[0][1];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][0] <= envelopes[i][0]) {
                    dp[i] = dp[j] + envelopes[i][1];
                }
               else if (envelopes[i][0] > envelopes[j][0]) {
                    if (envelopes[i][1] > envelopes[j][1]) {
                        dp[i] = dp[j] + envelopes[i][1];
                    }else {
                        dp[i]=dp[j];
                    }
                }
            }

        }
        return dp[n - 1];

    }
}
