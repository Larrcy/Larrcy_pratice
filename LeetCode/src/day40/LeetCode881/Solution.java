package day40.LeetCode881;

import java.util.Arrays;

public class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int light = 0, heavy = people.length - 1;
        //将数组排序后从数组两边查找
        //若最轻的和最重的小于limit则缩小窗口同时船只数量+1
        //若最轻的和最重的大于limit则移除最大的让最大的单独用一条船
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                ++light;
            }
            --heavy;
            ++ans;
        }
        return ans;
    }

}
