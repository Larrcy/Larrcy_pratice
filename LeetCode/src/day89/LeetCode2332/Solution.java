package day89.LeetCode2332;

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始长度为 n 的整数数组 buses ，其中 buses[i] 表示第 i 辆公交车的出发时间。同时给你一个下标从 0 开始长度为 m 的整数数组 passengers ，其中 passengers[j] 表示第 j 位乘客的到达时间。所有公交车出发的时间互不相同，所有乘客到达的时间也互不相同。
 * <p>
 * 给你一个整数 capacity ，表示每辆公交车 最多 能容纳的乘客数目。
 * <p>
 * 每位乘客都会搭乘下一辆有座位的公交车。如果你在 y 时刻到达，公交在 x 时刻出发，满足 y <= x  且公交没有满，那么你可以搭乘这一辆公交。最早 到达的乘客优先上车。
 * 返回你可以搭乘公交车的最晚到达公交站时间。你 不能 跟别的乘客同时刻到达。
 */
public class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        //首先对车和乘客按从小到大的顺序排序
        Arrays.sort(buses);
        Arrays.sort(passengers);
        //遍历公交车 找哪些乘客可以上车
        //将有2种情况出现
        //1.如果最后一班公交还有空位，我们可以在最后一班车发车时到达公交站，如果该时刻有人则我们需要继续往前找没人的时刻
        //2.如果最后一班公交没有空位 那我们需要找到该班公交车最后一个上车的乘客，找到该乘客之前没人到达的时刻
        int j = 0, c = 0;
        for (int bus : buses) {
            //找到最后一班车到达前，最晚到达的乘客
            for (c = capacity; c > 0 && j < passengers.length && passengers[j] <= bus; --c) {
                j++;
                System.out.println(j);
            }
        }
        j--;

        // 在发车时到达公交站 or 上一个上车的乘客
        int ans = c > 0 ? buses[buses.length - 1] : passengers[j];
        while (j >= 0 && passengers[j] == ans) {
            ans--; // 往前找没人到达的时刻
            j--;
        }
        return ans;

    }
}

