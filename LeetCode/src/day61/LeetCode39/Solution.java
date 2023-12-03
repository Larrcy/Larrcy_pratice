package day61.LeetCode39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        backtracking(candidates, target, 0);
        return res;
    }
    //组合问题用start控制
    //组合问题用i可以实现无限次用一个元素 i+1可以只用某元素一次
    // 若所给的集合有重复元素 则要先排序然后再比较
    // i > start && candidates[i] == candidates[i - 1]进行集合去重 如116 和161是两个相同的集合
    public void backtracking(int[] candidates, int target, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
        }
        if (sum > target) return;
        for (int i = start; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, i + 1);
            sum -= candidates[i];
            path.removeLast();
        }
    }

}