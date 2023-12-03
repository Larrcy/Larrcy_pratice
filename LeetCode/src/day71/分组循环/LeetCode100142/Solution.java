package day71.分组循环.LeetCode100142;

import java.util.Arrays;

/**
 * 分组循环
 * 将数组分成若干份每份进行排序最后收集结果
 * 给你一个下标从 0 开始的 正整数 数组 nums 和一个 正整数 limit 。
 *
 * 在一次操作中，你可以选择任意两个下标 i 和 j，如果 满足 |nums[i] - nums[j]| <= limit ，则交换 nums[i] 和 nums[j] 。
 *
 * 返回执行任意次操作后能得到的 字典序最小的数组 。
 *
 * 如果在数组 a 和数组 b 第一个不同的位置上，数组 a 中的对应字符比数组 b 中的对应字符的字典序更小，则认为数组 a 就比数组 b 字典序更小。例如，数组 [2,10,3] 比数组 [10,2,3] 字典序更小，下标 0 处是两个数组第一个不同的位置，且 2 < 10 。
 */
public class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        //题目要求如下
        //如果满足 |nums[i] - nums[j]| <= limit ，则交换 nums[i] 和 nums[j]
        //返回执行任意次操作后能得到的字典序最小的数组。
        //例如3 2 7 1 6 5 8 limit=1
        //我们对其分组排序
        //可以得到group1：1 2 3 group2：5 6 7 8
        //将其合并 得到 1,2,5,3,6,7,8
        //观察后可以发现 每一组只在其对应的下标位置排序
        //因此将nums带着下标进行从小到大排序
        int n = nums.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> nums[i] - nums[j]);
        //ans收集结果
        int[] ans = new int[n];
        //下面是分组循环的模板(分组循环适用于数组被分割成若干组 且每组的处理逻辑相同的情况)
        for (int i = 0; i < n; ) {
            int st = i;
            //比较相邻数字首先要i++
            //防止越界
            i+=1;
            while (i < n &&  nums[ids[i]] - nums[ids[i - 1]] <= limit) {
                i += 1;
            }
            //内层循环结束后从 st到i-1都是满足条件的
            //Arrays.copyOfRange左闭右开区间
            Integer[] subIds = Arrays.copyOfRange(ids, st, i);
            //将满足条件的下标再从小到大排序用来收集结果
            //如第一组的下标为 0 1 3
            //第二组的下标为 2 4 5 6
            Arrays.sort(subIds);
            for (int j = 0; j < subIds.length; j++) {
                ans[subIds[j]] = nums[ids[st + j]];
            }
        }
        return ans;
    }


}
