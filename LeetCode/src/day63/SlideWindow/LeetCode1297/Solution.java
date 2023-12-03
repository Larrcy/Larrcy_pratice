package day63.SlideWindow.LeetCode1297;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 * 给你一个字符串 s ，请你返回满足以下条件且出现次数最大的 任意 子串的出现次数：
 * <p>
 * 子串中不同字母的数目必须小于等于 maxLetters 。
 * 子串的长度必须大于等于 minSize 且小于等于 maxSize 。
 */
public class Solution {
        //maxSize无用
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String,Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0;i <= s.length()-minSize;i++){
            String sub = s.substring(i,i+minSize);
            if (isValid(sub,maxLetters)){
                map.put(sub,map.getOrDefault(sub,0)+1); //统计最短长度的所有单词出现次数
                if (map.get(sub) > res){
                    res = map.get(sub);
                }
            }
        }
        return res;
    }
    private boolean isValid(String s,int maxLetters){       //单词中的字母数是否符合要求
        boolean[] chars = new boolean[26];        //只有小写字母，统计字母是否出现过
        int sum = 0;                        //不同字母出现的次数
        for (int i = 0;i < s.length();i++){
            if (!chars[s.charAt(i)-'a']) {     //没有出现过的字母
                sum++;
                chars[s.charAt(i)-'a'] = true;
            }
            if (sum > maxLetters){          //不同字母出现次数超过最多次数
                return false;
            }
        }
        return true;
    }


}
