package day17.LeetCode491;

import java.util.*;

public class Solution {
    public LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int startIndex) {
        //题目要求数组长度至少为2
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }
        //用set来记录元素是否被遍历过
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            //若要添加的元素小于目前集合中最右边的元素则一定不和题意
            if (!path.isEmpty() && nums[i] < path.getLast()) {
                continue;
            }
            //set进行去重
            if (!set.add(nums[i])) {
                continue;
            }
            //回溯操作
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();

        }
    }
}
