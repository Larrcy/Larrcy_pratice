package Char08.S16.LeetCode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        //used数组用于去重
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums,used);
        return res;
    }
    public void backtracking(int[]nums,boolean[] used){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
        }
        //每次都遍历整个数组
        for (int i = 0; i < nums.length; i++) {
            // used[i - 1] == true，说明同一树枝nums[i - 1]使用过
            // used[i - 1] == false，说明同一树层nums[i - 1]使用过
            // 如果同一树层nums[i - 1]使用过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            //要取没有取过的数
            if (used[i] == false) {
                //取过标记为true
                used[i]=true;
                path.add(nums[i]);
                backtracking(nums, used);
                path.removeLast();
                used[i]=false;
            }
        }
    }
}
