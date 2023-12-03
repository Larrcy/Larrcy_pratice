package day69.LeetCode2275;

/**
 * 对数组 nums 执行 按位与 相当于对数组 nums 中的所有整数执行 按位与 。
 *
 * 例如，对 nums = [1, 5, 3] 来说，按位与等于 1 & 5 & 3 = 1 。
 * 同样，对 nums = [7] 而言，按位与等于 7 。
 * 给你一个正整数数组 candidates 。计算 candidates 中的数字每种组合下 按位与 的结果。 candidates 中的每个数字在每种组合中只能使用 一次 。
 *
 * 返回按位与结果大于 0 的 最长 组合的长度。
 *
 *
 */
public class Solution {
    public int largestCombination(int[] candidates) {
        int max = Integer.MIN_VALUE;

        // 设 i 为需要统计的位数，最高需要统计 24 位。
        //
        // 因为 candidates[i] 最大值为 10^7；
        // 10^7 可以拆解为 10^6 * 10；
        // 2^10 是 1024，两个 2^10 大约就是 10^6 （1024 x 1024）;
        // 2^4 = 16 远远大于 10。
        // 所以 2^24 远远大于 10^7。
        for (int i = 0; i < 24; i++) {
            // 使用 cnt 统计某一位 1 的个数
            int cnt = 0;
            for (int cand : candidates) {
                // 1 << i 用于表示哪一位为 1，首先统计从右数第一位为 1 的个数。
                // 由于 1 << i 只有一位为 1，其余位都为 0，
                // 所以 cand & 1 << i 如果等于 0，则表示当前位为 0，否则 cnt 加 1。
                max = Math.max(max, cnt += (cand & 1 << i) == 0 ? 0 : 1);
            }
        }
        return max;
    }
}
