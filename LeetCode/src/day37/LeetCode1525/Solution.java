package day37.LeetCode1525;

import java.util.*;

public class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        int n = s.length();
        //先统计s中所有的字符数目
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //再开辟新的哈希表依次往里面放字符
            map2.put(c, map2.getOrDefault(c, 0) + 1);
            //每方一次在原来的哈希表中减少一次记录
            //减少到0则将其移除哈希表
            map1.put(c, map1.get(c) - 1);
            if (map1.get(c) == 0) {
                map1.remove(c);
            }
            //若长度相等则记录答案
            if (map1.size() == map2.size()) {
                ans++;
            }
        }
        return ans;
    }

}
