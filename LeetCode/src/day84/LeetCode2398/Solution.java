package day84.LeetCode2398;

import java.util.PriorityQueue;

/**
 * 你有 n 个机器人，给你两个下标从 0 开始的整数数组 chargeTimes 和 runningCosts ，两者长度都为 n 。第 i 个机器人充电时间为 chargeTimes[i] 单位时间，花费 runningCosts[i] 单位时间运行。再给你一个整数 budget 。
 *
 * 运行 k 个机器人 总开销 是 max(chargeTimes) + k * sum(runningCosts) ，其中 max(chargeTimes) 是这 k 个机器人中最大充电时间，sum(runningCosts) 是这 k 个机器人的运行时间之和。
 *
 * 请你返回在 不超过 budget 的前提下，你 最多 可以 连续 运行的机器人数目为多少。
 */
public class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int maxRobots = 0;

        /*
        用优先队列PriorityQueue（最大堆）维护maxChargeTime，时间复杂度如下：
            插入: offer(E e)  O(logn)
            检索：peek()      O(1)
            删除：remove(E e) O(n)
        */
        PriorityQueue<Integer> maxChargeTime = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int n = chargeTimes.length;
        long sumRunningCosts = 0;
        int k=0;
        for(int i=0, j=0; j<n; j++){
            //右指针移动，运行时间累加
            maxChargeTime.offer(chargeTimes[j]);
            sumRunningCosts += runningCosts[j];
            k = j-i+1;
            long curBudget = maxChargeTime.peek() + k*sumRunningCosts;

            if(curBudget > budget){
                //左指针移动，最大充电时间需重新计算，运行时间减去最左边去掉的机器
                sumRunningCosts -= runningCosts[i];
                maxChargeTime.remove(chargeTimes[i]);
                i++;
            }else{
                maxRobots = Math.max(maxRobots, k);
            }
        }
        return maxRobots;
    }
}
