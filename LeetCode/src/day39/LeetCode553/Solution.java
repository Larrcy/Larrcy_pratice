package day39.LeetCode553;

public class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums.length == 1) return sb.append(nums[0]).toString();
        if (nums.length == 2) return sb.append(nums[0]).append("/").append(nums[1]).toString();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sb.append(nums[i]);
                sb.append("/(");
            } else if (i == nums.length - 1) {
                sb.append(nums[i]);
                sb.append(")");
            } else {
                sb.append(nums[i]);
                sb.append("/");
            }

        }
        return sb.toString();
    }
}
