package HJ100.JK171;

import java.util.*;
//相同数字的积木游戏
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(func(nums));

    }

    public static int func(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        if (map.size() == nums.length) return -1;
        int max = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            int len = map.get(key).size();
            if (len == 1) continue;
            Collections.sort(map.get(key));
            max = Math.max(max, map.get(key).get(len - 1) - map.get(key).get(0));
        }
        return max;
    }
}
