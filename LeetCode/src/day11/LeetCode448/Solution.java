package day11.LeetCode448;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer>set =new HashSet<>();
        List<Integer>list =new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <=nums.length; i++) {
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }


}
