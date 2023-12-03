package day44.Week319.LeetCode2470;

public class Solution {
    //n的范围只有1000故可以枚举
    //求最小公倍数 t= a*b/gcd(a,b)
    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            for (int j = i; j < n; j++) {
                temp = temp * nums[j] / gcd(temp, nums[j]);
                if (temp == k) ans++;
                else if (temp > k) break;
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
