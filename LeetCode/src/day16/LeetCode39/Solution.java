package day16.LeetCode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>>res =new ArrayList<>();
    public LinkedList<Integer>path =new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //要进行排序 不然超过目标值后会直接进行回溯导致结果丢失
        Arrays.sort(candidates);
        backtracking(candidates,0,target,0);
        return res;
    }
    public void backtracking(int[] candidates,int sum ,int target,int startIndex){
        if(sum==target){
            res.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < candidates.length; i++) {
            //当大于时中止循环
            if (sum + candidates[i] > target) break;
            sum+=candidates[i];
            path.add(candidates[i]);
            backtracking(candidates,sum,target,i);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
