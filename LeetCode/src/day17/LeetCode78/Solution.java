package day17.LeetCode78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public LinkedList<Integer>path =new LinkedList<>();
    public List<List<Integer>>res =new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums,0);
        res.add(null);
        return res;

    }
    public void backtracking(int[] nums ,int startIndex){
        //将空集也添加进结果集
        //放在循环里面会导致空集丢失
        res.add(new ArrayList<>(path));
        if(startIndex==nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums,i+1);
            path.removeLast();
        }
    }
}
