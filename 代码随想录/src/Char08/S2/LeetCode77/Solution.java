package Char08.S2.LeetCode77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>>res =new ArrayList<>();
    public LinkedList<Integer>path=new LinkedList<>();

    {
    };
    public static void main(String[] args) {

    }
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return res;
    }
    public void backtracking(int n,int k,int startIndex){
    if(path.size()==k){
        //不用new ArrayList<>得到的集合会为空
        res.add(new ArrayList<>(path));
        return;
    }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }

    }
}
