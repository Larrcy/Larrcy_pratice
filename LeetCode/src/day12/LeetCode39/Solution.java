package day12.LeetCode39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] candidates={2,3,6,7};
        int target=7;
        combinationSum(candidates,target);

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int left = 0;
        int right = 0;
        int sum = 0;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            sum = sum + candidates[i];
            right++;
            while (sum == target) {

                for ( ; left < right; left++) {
                    list.add(candidates[i]);

                }
                res.add(list);
            }
            while (sum>target){
                sum=sum-candidates[left];
                left++;
            }
        }
        return res;
    }
}
