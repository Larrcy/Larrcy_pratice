package day63.贪心.LeetCode2007;

import java.util.*;

/**
 * 一个整数数组 original 可以转变成一个 双倍 数组 changed ，转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
 * <p>
 * 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，否则请返回空数组。original 的元素可以以 任意 顺序返回。
 */
public class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[]{};
        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) != 0 && (!map.containsKey(2 * key)) || (map.containsKey(2 * key) && map.get(key) > map.get(2 * key)))
                return new int[]{};
            else if (key == 0) {
                if (map.get(key) % 2 == 0) {
                    for (int i = 0; i < map.get(key) / 2; i++) {
                        list.add(0);
                    }
                }
            } else if (map.containsKey(2 * key) && map.get(key) <= map.get(2 * key)) {
                int len = map.get(key);
                for (int i = 0; i < len; i++) {
                    list.add(key);
                }
                map.put(key, 0);
                map.put(2 * key, map.get(2 * key) - len);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;

    }
}
