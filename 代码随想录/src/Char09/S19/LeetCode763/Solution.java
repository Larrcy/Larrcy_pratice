package Char09.S19.LeetCode763;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        //利用map记录最远的字符下标
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        //定义集合存储结果集
        List<Integer> res = new ArrayList<>();
        //定义左右指针来计算字符串长度
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            //记录最右边的位置
            right = Math.max(right, map.get(s.charAt(i)));
            //若达到最右边的位置则进行记录
            if (i == right) {
                res.add(right - left + 1);
                //更新左边界记录下一轮
                left=i+1;
            }
        }
        return  res;
    }
}
