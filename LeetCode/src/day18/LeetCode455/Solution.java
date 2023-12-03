package day18.LeetCode455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        //从s的最大位开始
        int start = s.length - 1;
        // 遍历胃口
        for (int i = g.length - 1; i >= 0; i--) {
            //若满足胃口
            if (start >= 0 && g[i] <= s[start]) {
                //则向前遍历
                start--;
                count++;
            }
        }
        return count;
    }
}
