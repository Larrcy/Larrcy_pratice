package day50.LeetCode42;

public class Solution2 {
    public int trap(int[] height) {
        int n = height.length;
        //分别求前缀和后缀的最大值然后再与高度相减
        int preMax = 0;
        int sufMax = 0;
        int ans = 0;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            if (preMax < sufMax) {
                ans += preMax - height[left];
                left += 1;
            } else {
                ans += sufMax - height[right];
                right -= 1;
            }
        }
        return ans;
    }

}
