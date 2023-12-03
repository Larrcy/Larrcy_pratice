package Char08.S8.LeetCode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>>res =new ArrayList<>();
    public LinkedList<Integer> path =new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return res;
    }
    public void backtracking(int[] candidates, int target,int sum ,int startIndex){
        if(target==sum&&!res.contains(path)){
            res.add(new ArrayList<>(path));
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if(sum+candidates[i]>target)break;
            //若重复则跳过节点
            if ( i > startIndex && candidates[i] == candidates[i - 1] ) {
                continue;
            }
            sum+=candidates[i];
            path.add(candidates[i]);
            backtracking(candidates,target,sum,i+1);
            sum-=candidates[i];
            path.removeLast();
        }
    }
}
