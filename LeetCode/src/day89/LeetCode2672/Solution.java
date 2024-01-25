package day89.LeetCode2672;

/**
 * 给你一个下标从 0 开始、长度为 n 的数组 nums 。一开始，所有元素都是 未染色 （值为 0 ）的。
 *
 * 给你一个二维整数数组 queries ，其中 queries[i] = [indexi, colori] 。
 *
 * 对于每个操作，你需要将数组 nums 中下标为 indexi 的格子染色为 colori 。
 *
 * 请你返回一个长度与 queries 相等的数组 answer ，其中 answer[i]是前 i 个操作 之后 ，相邻元素颜色相同的数目。
 *
 * 更正式的，answer[i] 是执行完前 i 个操作后，0 <= j < n - 1 的下标 j 中，满足 nums[j] == nums[j + 1] 且 nums[j] != 0 的数目。
 *
 *
 */
public class Solution {
    //根据题目要求可以发现每次向数组添加元素 其只影响该元素左右两边的元素
    //因此我们首先不考虑该元素对答案的影响
    //因此从答案中减去其影响
    //然后将新的元素添加进来再加回来新元素的影响
    public int[] colorTheArray(int n, int[][] queries) {
        int q = queries.length, cnt = 0;
        int[] ans = new int[q], a = new int[n + 2]; // 避免讨论下标出界的情况
        for (int qi = 0; qi < q; qi++) {
            int i = queries[qi][0] + 1, c = queries[qi][1]; // 下标改成从 1 开始
            if (a[i] > 0){
                cnt -= (a[i] == a[i - 1] ? 1 : 0) + (a[i] == a[i + 1] ? 1 : 0);
            }
            a[i] = c;
            cnt += (a[i] == a[i - 1] ? 1 : 0) + (a[i] == a[i + 1] ? 1 : 0);
            ans[qi] = cnt;
        }
        return ans;
    }
}
