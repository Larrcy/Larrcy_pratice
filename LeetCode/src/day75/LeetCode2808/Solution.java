package day75.LeetCode2808;

import java.util.*;

/**
 * 扩散问题 给你一个下标从 0 开始长度为 n 的数组 nums 。
 * <p>
 * 每一秒，你可以对数组执行以下操作：
 * <p>
 * 对于范围在 [0, n - 1] 内的每一个下标 i ，将 nums[i] 替换成 nums[i] ，nums[(i - 1 + n) % n] 或者 nums[(i + 1) % n] 三者之一。
 * 注意，所有元素会被同时替换。
 * <p>
 * 请你返回将数组 nums 中所有元素变成相等元素所需要的 最少 秒数。
 */
public class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        // 记录每个元素出现的位置下标
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            if (!map.containsKey(nums.get(i))) map.put(nums.get(i), new ArrayList<>());
            map.get(nums.get(i)).add(i);
        }
        //考虑把数字 x「扩散」到其它位置，那么每一秒 x 都可以向左右扩散一位。
        //最多耗时为n/2
        int ans = n / 2;
        //统计所有相同数字的下标，记到一个哈希表中。
        //本题数组可以视作是环形的，假设最左边的 x 的下标是 i，只需要在哈希表表末尾添加一个 i+n，就可以转换成非环形数组处理了。
        //例如数组为2 4 3 3 3 4 最左边的3下标为2 再拼接一个数组得 2 4 3 3 3 4 2 4 3
        //则成环的最后一个3的下标为8 即i+n
        //只需要考虑边界即可
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            list.add(list.get(0) + n);
            int mx = -1;
            for (int j = 1; j < list.size(); j++) {
                mx = Math.max(mx, (list.get(j) - list.get(j - 1)) / 2);
            }
            ans = Math.min(ans, mx);
        }
        return ans;
    }
}
