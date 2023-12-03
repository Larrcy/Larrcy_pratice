package day71.分组循环.LeetCode228;

import java.util.ArrayList;
import java.util.List;

/**
 *分组排序 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        int i = 0;
        List<String> list = new ArrayList<>();
        while (i < n) {
            int start = i;
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            i++;
            while (i < n && nums[i] - nums[i - 1] == 1) {
                i++;
                flag = true;
            }
            if (flag) {
                sb.append("->").append(nums[i - 1]);
            }
            list.add(sb.toString());
            sb = new StringBuilder();
        }
        return list;
    }
}
