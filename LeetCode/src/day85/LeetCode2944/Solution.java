package day85.LeetCode2944;

/**
 * 你在一个水果超市里，货架上摆满了玲琅满目的奇珍异果。
 *
 * 给你一个下标从 1 开始的数组 prices ，其中 prices[i] 表示你购买第 i 个水果需要花费的金币数目。
 *
 * 水果超市有如下促销活动：
 *
 * 如果你花费 price[i] 购买了水果 i ，那么接下来的 i 个水果你都可以免费获得。
 * 注意 ，即使你 可以 免费获得水果 j ，你仍然可以花费 prices[j] 个金币去购买它以便能免费获得接下来的 j 个水果。
 *
 * 请你返回获得所有水果所需要的 最少 金币数。
 */
public class Solution {
    //定义 dfs(i) 表示获得第 i个及其后面的水果所需要的最少金币数。注意 i从 1 开始
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        int memo[] = new int[n];
        return dfs(1, prices, memo);
    }

    private int dfs(int i, int[] prices, int[] memo) {
        //如果从当前位置之后可以免费获取的水果数超过数组长度则直接返回该位置的价格
        if (i * 2 >= prices.length) {
            return prices[i - 1]; // i 从 1 开始
        }
        //记忆化搜索
        if (memo[i] != 0) { // 之前算过
            return memo[i];
        }
        int res = Integer.MAX_VALUE;
        //选择第i个水果会使[i+1,2i]区间内的水果都是免费的
        //枚举下一个需要购买的水果 [i+1,2i]全部跳过后需要买第2i+1个水果
        //即[i+1,2i+1]内的水果
        for (int j = i + 1; j <= i * 2 + 1; j++) {
            res = Math.min(res, dfs(j, prices, memo));
        }
        return memo[i] = res + prices[i - 1]; // 记忆化
    }
}
