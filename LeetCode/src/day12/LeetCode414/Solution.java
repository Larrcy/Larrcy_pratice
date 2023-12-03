package day12.LeetCode414;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {

    }

    public int thirdMax(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        list = list.stream().distinct().collect(Collectors.toList());
        if (list.size() < 3) {
            return list.get(list.size() - 1);
        }
        return list.get(list.size() - 3);

    }
}
