package day16.LeetCode2325;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String decodeMessage(String key, String message) {
        String res ="";
        Map<Character,Character>map =new HashMap<>();
        map.put(' ',' ');
        int ch =97;
        for (int i = 0; i < key.length(); i++) {
            if(key.charAt(i)!=' '&&!map.containsKey(key.charAt(i))) {
                map.put(key.charAt(i), (char) ch);
                if (ch < 122) {
                    ch++;
                }
            }
        }
        for (int i = 0; i < message.length(); i++) {

            res+=map.get(message.charAt(i));

        }
        return res;
    }

}
