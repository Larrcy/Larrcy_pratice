package day29.LeetCode2553;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer>list =new ArrayList<>();
        for (int i = nums.length-1; i >=0 ; i--) {
            while (nums[i]>0){
                list.add(nums[i]%10);
                nums[i]=nums[i]/10;
            }
        }
        Collections.reverse(list);
        int[]res =new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}
