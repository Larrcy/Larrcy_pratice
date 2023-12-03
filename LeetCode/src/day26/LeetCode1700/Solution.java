package day26.LeetCode1700;

import java.util.*;

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        //分别统计喜欢圆形和方形的人
        //圆形为0 方形为1
        for (int i : students) cnt[i]++;
        for (int sandwich : sandwiches) {
            //对方形和圆形进行匹配
            //按照三明治顺序进行匹配 三明治顺序是不可变的
            //当无法匹配时跳出循环 统计剩余人数
            if (cnt[sandwich] > 0) cnt[sandwich]--;
            else break;
        }
        return cnt[0] + cnt[1];
    }
}
