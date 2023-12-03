package day07.LeetCode383;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] str1 = ransomNote.toCharArray();
        char[] str2 = magazine.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char z : str1) {//把ransomNote的值存进哈希表，如果存在相同，则value +1
            if (map.containsKey(z)) {
                map.put(z, map.get(z) + 1);
            } else {
                map.put(z, 1);
            }
        }

        for (char z : str2) {//通过遍历magazine字符来抵消ransomNote字符
            if (map.containsKey(z)) {
                map.put(z, map.get(z) - 1);

            }
        }

        for (char z : str1) {//因为ransomNote与哈希表key相似，所以通过ransomNote遍历hashmap
            int index = map.get(z);
            if (index > 0) {//如果index存在大于0的，说明magazine未能完全抵消ransomNote，即不能由他里面的字符构成
                return false;
            }
        }

        return true;


    }
}
