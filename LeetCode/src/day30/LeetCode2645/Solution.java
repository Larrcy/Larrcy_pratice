package day30.LeetCode2645;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    //计算出 ‘abc’ 的周期数 t，那么有效字符串的长度为 3t，需要插入的字符个数为 3t−n。
    //对于两个相邻字符x和y（x在y左侧），如果 x<y，那么x和y可以在同一个 ‘abc’ 周期内，否则一定不在。
    public int addMinimum(String word) {
        char[] s = word.toCharArray();
        int t = 1;
        for (int i = 1; i < s.length; ++i)
            if (s[i - 1] >= s[i]) // 必须生成一个新的 abc
                ++t;
        return t * 3 - s.length;
    }
}
