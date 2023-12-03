package day28.LeetCode2053;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                k--;
            }
            if (k == 0) {
                return arr[i];
            }
        }
        return "";
    }
}
