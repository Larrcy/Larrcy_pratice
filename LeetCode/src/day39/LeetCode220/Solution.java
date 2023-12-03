package day39.LeetCode220;

public class Solution {
    public static void main(String[] args) {
        int []nums ={-2147483648,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(nums, 1, 1));
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long m =Math.abs((long) nums[i] - (long) nums[j]);
                if (m <= t && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
