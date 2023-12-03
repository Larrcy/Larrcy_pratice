package day05.LeetCode205;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        //利用哈希表存储
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        //遍历字符串
        for (int i = 0; i < len; ++i) {
            //获取当前字符串对应的字符
            char x = s.charAt(i), y = t.charAt(i);
            //若哈希表中已存在对应关系
            //如 foo bar
            //o ->a已存入哈希表
            //下一次为o->r此时会出现一对多的情况 不满足题意
            //只有下一次也满足 o->a才满足题意
            //映射是双向的 若a--d 则d一定要映射a d--a
            //故要创建两个哈希表
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}
