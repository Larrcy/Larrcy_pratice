package day63.贪心.LeetCode846;

import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 * <p>
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌上的数值。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 */
public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len = hand.length;
        // 每组大小为groupSize
        if(len % groupSize != 0)
            return false;
        // 排序后将元素出现次数存入哈希表
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : hand)
            map.put(num, map.getOrDefault(num, 0) + 1);
        // 由于事先对数组排序 所以顺子肯定是连续出现
        for(int num : hand)
            // 依次遍历排序后数组。如果当前数哈希值大于0 则连续groupSize个是否存入哈希
            if(map.get(num) > 0)
                for(int i = 0; i < groupSize; i++){
                    // 如果连续的数存在 则之前已存入哈希表 消去一次；否则 不是顺子 直接return
                    if(map.get(num + i) != null && map.get(num + i) > 0)
                        map.put(num + i, map.get(num + i) - 1);
                    else
                        return false;
                }
        return true;
    }
}
