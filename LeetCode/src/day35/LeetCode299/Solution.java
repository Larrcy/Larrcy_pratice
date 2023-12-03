package day35.LeetCode299;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String getHint(String secret, String guess) {
        String res = "";
        int A = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
                continue;
            }
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            map2.put(guess.charAt(i), map2.getOrDefault(guess.charAt(i), 0) + 1);
        }
        int B = 0;
        for (Character key : map2.keySet()) {
            if (map.containsKey(key)) {
                B += Math.min(map.get(key), map2.get(key));
            }
        }
        return A + "A" + B + "B";

    }
}
