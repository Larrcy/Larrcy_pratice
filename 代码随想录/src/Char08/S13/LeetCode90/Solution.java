package Char08.S13.LeetCode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int startIndex) {
       if(!res.contains(new ArrayList<>(path)))
        res.add(new ArrayList<>(path));
        if (startIndex == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
