package day14.LeetCode16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        int[]nums ={-1,2,1,-4};
        int target =1;
        System.out.println(threeSumClosest(nums, target));
    }
    public  static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                list.add(sum);
                while (right > left && nums[right] == nums[right - 1]) right--;
                while (right > left && nums[left] == nums[left + 1]) left++;
                right--;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            res.add(Math.abs(target-list.get(i)));
        }
        int p=0;
        List<Integer> collect = res.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < res.size(); i++) {
            if(collect.get(0)== res.get(i)){
                p=i;
            }
        }
        return list.get(p);

    }
}
