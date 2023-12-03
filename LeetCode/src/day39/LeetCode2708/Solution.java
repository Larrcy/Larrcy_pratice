package day39.LeetCode2708;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        long sum1 = 1;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) list.add(nums[i]);
            if (nums[i] == 0) count++;
            if (nums[i] > 0) {
                list2.add(nums[i]);
                sum1 *= nums[i];
            }
        }
        if (count == nums.length) return 0;
        long sum2 = 1;
        for (int i = 0; i < list.size(); i++) {
            sum2 *= list.get(i);
        }
        if (list.size() % 2 == 0) return sum1 * sum2;
        if (list.size() % 2 != 0 && list2.size()!=0) return sum1 * sum2 / list.get(list.size() - 1);
        if (list.size() == 1 && list2.size()==0&&count!=0)return 0;
        if (list.size() == 1 && list2.size()==0&&count==0)return sum2;
        if(list.size() % 2 != 0&&list2.size()==0)return sum2 / list.get(list.size() - 1);
        else return 0;
    }
}
