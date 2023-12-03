package day35.LeetCode506;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {
    public String[] findRelativeRanks(int[] score) {
        //构建大顶堆
        //先让所有元素入队
        //然后依次弹出得到的序列即为从大到小的序列
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < score.length; i++) {
            queue.add(new int[]{score[i], i});
        }

        String[] res = new String[score.length];
        int m = queue.size();
        int flag = 4;
        while (!queue.isEmpty()) {
            //根据队列长度来进行判断名次
            int[] x = queue.poll();
            if (queue.size() == m - 1) {
                res[x[1]] = "Gold Medal";
            } else if (queue.size() == m - 2) {
                res[x[1]] = "Silver Medal";
            } else if (queue.size() == m - 3) {
                res[x[1]] = "Bronze Medal";
            } else {
                res[x[1]] = String.valueOf(flag);
                flag++;
            }
        }
        return res;
    }


}
