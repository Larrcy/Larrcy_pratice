package day27.LeetCode953;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"kuvp", "q"};
        String order = "ngxlkthsjuoqcpavbfdermiywz";
        System.out.println(isAlienSorted(words, order));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int p = 0, q = 1; q < words.length; ) {
            if (words[p].length() >= words[q].length()) {
                for (int i = 0; i < words[q].length(); ) {
                    if (map.get(words[p].charAt(i)) > map.get(words[q].charAt(i))) {
                        return false;
                    }
                    if (map.get(words[p].charAt(i)) < map.get(words[q].charAt(i))) {
                        break;
                    }
                    if (map.get(words[p].charAt(i)) == map.get(words[q].charAt(i))) {
                        i++;
                        if(i==words[q].length()-1&&i<words[p].length()-1){
                            return false;
                        }
                    }

                }
                p++;
                q++;
            } else {
                for (int i = 0; i < words[p].length(); ) {
                    if (map.get(words[p].charAt(i)) > map.get(words[q].charAt(i))) {
                        return false;
                    }
                    if (map.get(words[p].charAt(i)) < map.get(words[q].charAt(i))) {
                        break;
                    }
                    if (map.get(words[p].charAt(i)) == map.get(words[q].charAt(i))) {
                        i++;
                        if(i==words[p].length()-1&&i<words[q].length()-1){
                            return false;
                        }
                    }

                }
                p++;
                q++;
            }
        }
        return true;
    }
}
