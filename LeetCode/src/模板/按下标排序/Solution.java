package 模板.按下标排序;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个下标从 0 开始的字符串数组 nums ，其中每个字符串 长度相等 且只包含数字。
 *
 * 再给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [ki, trimi] 。对于每个 queries[i] ，你需要：
 *
 * 将 nums 中每个数字 裁剪 到剩下 最右边 trimi 个数位。
 * 在裁剪过后的数字中，找到 nums 中第 ki 小数字对应的 下标 。如果两个裁剪后数字一样大，那么下标 更小 的数字视为更小的数字。
 * 将 nums 中每个数字恢复到原本字符串。
 * 请你返回一个长度与 queries 相等的数组 answer，其中 answer[i]是第 i 次查询的结果。
 */
public class Solution {
    //按下标排序模板
    public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            List<String> list = new ArrayList<>();
            List<Integer> ids = new ArrayList<>();

            for (int j = 0; j < nums.length; j++) {
                list.add(nums[j].substring(nums[i].length() - queries[i][1]));
            }
            for (int j = 0; j < nums.length; j++) {
                ids.add(j);
            }
            Collections.sort(ids,(x, y)->list.get(x).compareTo(list.get(y)));
            res[i] = ids.get(queries[i][0] - 1);
        }
        return res;
    }
}
