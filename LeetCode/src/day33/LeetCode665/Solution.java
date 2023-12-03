package day33.LeetCode665;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int p = 0, q = 1; q < nums.length; ) {
            if (nums[p] <= nums[q]) {
                p++;
                q++;
            }else {
                count++;
            }
        }
        return count<=1;
    }
}
