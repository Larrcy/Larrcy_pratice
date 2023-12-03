package day17.LeetCode46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
    backtracking(nums);
    return res;
    }
    public void backtracking(int[]nums){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
        }
        //每次都遍历整个数组
        for (int i = 0; i < nums.length; i++) {
            //当路径中存在值则将其排除
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            backtracking(nums);
            path.removeLast();
        }
    }
}
