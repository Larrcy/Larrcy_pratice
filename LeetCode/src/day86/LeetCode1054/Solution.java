package day86.LeetCode1054;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 *
 * 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 *
 *
 */
public class Solution {
    //统计所有数字的出现次数 从大到小插空放
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = barcodes.length;
        List<Integer> ans = new ArrayList<>();
        for (int num : barcodes) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            ans.add(num);
        }
        ans.sort((a, b) -> map.get(a).equals(map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a));
        int[] res = new int[n];
        for (int k = 0, j = 0; k < 2; ++k) {
            for (int i = k; i < n; i += 2) {
                res[i] = ans.get(j++);
            }
        }
        return res;

    }
}
