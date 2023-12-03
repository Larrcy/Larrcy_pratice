package day56.LeetCode1647;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class Solution {
    public int minDeletions(String s) {
        int[] a = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) a[c - 'a'] ++;// 统计字母个数

        Set<Integer> h = new HashSet<Integer>();
        int res = 0;
        for (int i : a) {
            if (i != 0) {               // 有数目才进行判断
                while (h.contains(i)) { // set已经包含就自减
                    i --;
                    res ++;
                }
                if (i != 0) h.add(i);   // 自减到0时，表示完全删除了某个字母，不能加入set中
            }
        }
        return res;
    }


}
