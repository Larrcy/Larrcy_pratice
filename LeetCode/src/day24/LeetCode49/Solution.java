package day24.LeetCode49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //map y用来存放对数组中每一个元素排序后的对应的不同元素
        //如 abc acb cba
        //map(abc : acb cba,abc)
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            //把字符数组转为字符串
            String key = new String(chars);
            //第一次往map里添加新元素则创建一个新集合进行存储
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            //若再次出现相同的元素则往value里进行添加
            else {
                map.get(key).add(strs[i]);
            }

        }
        //最后把map的值进行输出
        return new ArrayList<>(map.values());
    }
}

