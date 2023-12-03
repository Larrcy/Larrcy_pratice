package HJ100.JK169;

import java.util.*;
//通信误码
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        int maxLen = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key).size() > maxLen) {
                maxLen = map.get(key).size();
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            int len = map.get(key).size();
            if (len == maxLen) {
                Collections.sort(map.get(key));
                min = Math.min(map.get(key).get(len - 1) - map.get(key).get(0)+1, min);

            }
        }
        System.out.println(min);
    }
}
