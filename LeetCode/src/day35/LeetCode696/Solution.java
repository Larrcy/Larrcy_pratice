package day35.LeetCode696;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //我们可以将字符串 s 按照 0 和 1 的连续段分组，
    //存储在 counts中，例如 s=00111011
    //可以得到这样的 counts数组：counts={2,3,1,2}
    //这里 counts数组中两个相邻的数一定代表的是两种不同的字符。
    //它们能组成的满足条件的子串数目为 min{u,v}，即一对相邻的数字对答案的贡献。

    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        for (int i = 0; i < n;) {
            char c =s.charAt(i);
            int count = 0;
            while (i < n && s.charAt(i) == c) {
                count++;
                i++;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }


}
