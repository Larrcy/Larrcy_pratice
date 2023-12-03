package day26.LeetCode2126;

import java.util.Arrays;

public class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long newmass = mass;
        Arrays.sort(asteroids);
        //排序后从小吃到大 吃不下则false
        for (int cur : asteroids) {
            if (newmass < cur) return false;
            newmass += cur;
        }
        return true;
    }

}
