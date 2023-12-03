package day36.Need.LeetCode1208;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s="abcd";
        String t ="acde";
        int maxCost =0;
        System.out.println(equalSubstring(s, t, maxCost));
    }
    public static int equalSubstring(String s, String t, int maxCost) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(Math.abs(s.charAt(i) - t.charAt(i)));
        }
        int left = 0;
        int max = 0;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < list.size(); ) {
            //maxCost=0的情况需要特判
            if (sum<=maxCost) {
                sum += list.get(i);
                count++;
                i++;
            }
            while (sum > maxCost) {
                sum -= list.get(left);
                left++;
                count--;

            }
            max = Math.max(max, count);

        }
        return max;
    }
}
