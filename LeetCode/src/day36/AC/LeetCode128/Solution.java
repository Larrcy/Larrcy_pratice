package day36.AC.LeetCode128;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            treeSet.add(nums[i]);
        }
        List<Integer> collect = new ArrayList<>();
        for (Integer key : treeSet) {
            collect.add(key);
        }
        int sum = 1;
        int max = 0;
        for (int i = 1; i < collect.size(); i++) {
            if (collect.get(i) - collect.get(i - 1) == 1) {
                sum++;
            } else {
                max = Math.max(sum, max);
                sum = 1;
            }
        }
        max = Math.max(sum, max);
        return max;
    }
}
