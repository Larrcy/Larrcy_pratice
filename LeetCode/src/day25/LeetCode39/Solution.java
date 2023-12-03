package day25.LeetCode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target,0);
        return res;
    }

    public void backtracking(int[] candidates, int target,int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target,i);
            path.removeLast();
            sum -= candidates[i];

        }
    }
}
