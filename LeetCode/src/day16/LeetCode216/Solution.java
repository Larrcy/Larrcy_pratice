package day16.LeetCode216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>>res =new ArrayList<>();
    public LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
            backtracking(k,n,0,1);
            return res;
    }
    public void backtracking(int k, int n,int sum,int startIndex){
        if(sum>n)return;
        if(path.size()==k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
        }
        for (int i = startIndex; i <= 9; i++) {
            sum+=i;
            path.add(i);
            backtracking(k,n,sum,i+1);
            sum-=i;
            path.removeLast();

        }

    }
}
