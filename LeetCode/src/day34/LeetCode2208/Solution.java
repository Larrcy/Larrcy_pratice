package day34.LeetCode2208;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int halveArray(int[] nums) {
        //构建最大堆
        PriorityQueue<Double> pq = new PriorityQueue<Double>((a, b) -> b.compareTo(a));
        //将所有元素都放入最大堆
        for (int num : nums) {
            pq.offer((double) num);
        }
        int res = 0;
        double sum = 0;
        //sum记录数组的和
        for (int num : nums) {
            sum += num;
        }
        //sum2记录数组的减少和
        double sum2 = 0.0;
        //当sum2<sum/2时进行循环操作
        while (sum2 < sum / 2) {
            //首先从队列中取出最大值
            double x = pq.poll();
            //将其加到sum2中
            sum2 += x / 2;
            //再将其的一半重新放入队列
            pq.offer(x / 2);
            res++;
        }
        return res;
    }

}
