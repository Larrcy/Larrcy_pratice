package day28.LeetCode2405;

import java.util.LinkedHashSet;
import java.util.Set;

public class Solution {
    public int partitionString(String s) {
        Set<Character> set = new LinkedHashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                count++;
                set.clear();
                //继续判断当前重复的元素 若不执行i--则会跳过当前元素
                i--;
            }
        }
        //将最后那一段不重复的字符串加上
        return count+1;
    }
}
