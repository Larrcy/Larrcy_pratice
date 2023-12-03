package day41.LeetCode524;

import java.util.*;
//贪心法
public class Solution {
    //根据题意，我们需要找到 dictionary 中为 s 的子序列，且「长度最长（优先级 1）」及「字典序最小（优先级 2）」的字符串。
    //数据范围全是 1000。
    //我们可以先对 dictionary 根据题意进行自定义排序：
    //长度不同的字符串，按照字符串长度排倒序；
    //长度相同的，则按照字典序排升序。
    //然后我们只需要对 dictionary 进行顺序查找，找到的第一个符合条件的字符串即是答案。

    public String findLongestWord(String s, List<String> list) {
        Collections.sort(list, (a,b)->{
            if (a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        //使用两个指针 i 和 j 分别代表检查到 s 和 dictionary[x] 中的哪位字符；
        //当 s[i] != dictionary[x][j]，我们使 i 指针右移，直到找到 s 中第一位与 dictionary[x][j] 对得上的位置，然后当 i 和 j 同时右移，匹配下一个字符；
        //重复步骤 2，直到整个 dictionary[x] 被匹配完
        int n = s.length();
        for (String ss : list) {
            int m = ss.length();
            int i = 0, j = 0;
            while (i < n && j < m) {
                if (s.charAt(i) == ss.charAt(j)) j++;
                i++;
            }
            if (j == m) return ss;
        }
        return "";
    }

}
