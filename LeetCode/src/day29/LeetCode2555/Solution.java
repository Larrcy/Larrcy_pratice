package day29.LeetCode2555;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        int[] prizePositions = {1, 1, 2, 2, 3, 3, 5};
        int k = 2;
        System.out.println(maximizeWin(prizePositions, k));
    }

    public static int maximizeWin(int[] pos, int k) {
        int ans = 0, left = 0, n = pos.length;
        //pre用于收集第一条线段所能达到的最大值
        int[] pre = new int[n + 1];
        //我们首先找第二条线段 即让第二条线段尽可能的覆盖到右边
        //枚举第二条线段的右端点
        //然后再在第二条线段的左边部分找第一条线段 并维护其最大值
        for (int right = 0; right < n; right++) {
            //找到右端点right
            while (pos[right] - pos[left] > k) {
                left++;
            }
            //最终结果就是左边的最大长度加上右边所维护的长度
            ans = Math.max(ans, right - left + 1 + pre[left]);
            //有可能后面的数比前面的数还小 故取最大值
            pre[right + 1] = Math.max(pre[right], right - left + 1);
        }
        return ans;
    }

}
