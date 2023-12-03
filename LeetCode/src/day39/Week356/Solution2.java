package day39.Week356;

import java.util.*;

public class Solution2 {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> curr = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                curr.add(nums[j]);
                count += curr.size() / set.size();
            }
        }
        return count;
    }
}
