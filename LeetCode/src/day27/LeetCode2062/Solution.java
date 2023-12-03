package day27.LeetCode2062;

import java.util.HashMap;

public class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;//定义结果变量
        for (int i = 0; i < word.length(); i++) {
            //声明一个map,每一次都进行初始化一下
            HashMap<Character,Integer> map = new HashMap<>();
            map.put('a',0);
            map.put('e',0);
            map.put('i',0);
            map.put('o',0);
            map.put('u',0);
            //如果当前节点不符合要求就不要往下看了
            if(!map.containsKey(word.charAt(i))) continue;
            //从该节点向右延伸
            for(int j = i; j < word.length();j++){
                //如果遇到非元音节点,就直接break
                if(!map.containsKey(word.charAt(j))) break;
                map.put(word.charAt(j),map.get(word.charAt(j))+1);
                if(isTrue(map)) count++;//判断是否包含全部元音
            }
        }
        return count;
    }

    //判断是否包含aeiou
    private boolean isTrue(HashMap<Character, Integer> map) {
        for (Character character : map.keySet()) {
            if(map.get(character) == 0) return false;
        }
        return true;
    }

}
