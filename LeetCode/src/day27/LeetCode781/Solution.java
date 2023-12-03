package day27.LeetCode781;

import java.util.*;

public class Solution {
    public static int numRabbits(int[] answers) {
        // 使用HashMap来记录每种兔子回答的个数
        Map<Integer, Integer> countMap = new HashMap<>();

        // 遍历兔子的回答数组，统计每种回答的个数
        for (int answer : answers) {
            countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
        }

        int minRabbits = 0;

        // 遍历HashMap，计算兔子的最少数量
        for (int answer : countMap.keySet()) {
            //count 表示该回答有多少个
            int count = countMap.get(answer);
            // 若回答是0，表示只有一只兔子，直接加1
            if (answer == 0) {
                minRabbits += count;
            } else {
                // 若回答不为0，则每种颜色的兔子最少有(answer + 1)只，
                //单独计算组数 不足1组则为0
                int set =(count) / (answer + 1);
                //再计算不足一组的兔子
                int remains = count % (answer + 1);
                //相加即可得最小值
                minRabbits +=  set* (answer + 1) + (remains == 0 ? 0 : (answer + 1));
            }
        }

        return minRabbits;
    }
}
