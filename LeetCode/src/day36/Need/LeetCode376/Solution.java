package day36.Need.LeetCode376;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        int up = 1;
        int down = 1;
        int ans = 1;
        //交替统计上升下降的序列
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;

            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;

            }
            ans =Math.max(ans, Math.max(up, down));
        }
        return ans;
    }
}
