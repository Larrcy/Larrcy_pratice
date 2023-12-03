package day33.LeetCode1346;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        long[] nums = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = 2 * arr[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (nums[i] == arr[j]&&i!=j) {
                    return true;
                }
            }

        }
        return false;
    }
}
