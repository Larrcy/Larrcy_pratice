package day21.LeetCode1470;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] shuffle(int[] nums, int n) {
        List<Integer>list1 =new ArrayList<>();
        List<Integer>list2 =new ArrayList<>();
        List<Integer>res =new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list1.add(nums[i]);
        }
        for (int i = n; i < nums.length; i++) {
            list2.add(nums[i]);
        }
        for (int i = 0; i < list1.size(); i++) {
            res.add(list1.get(i));
            res.add(list2.get(i));
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]=res.get(i);
        }
        return nums;
    }
}
