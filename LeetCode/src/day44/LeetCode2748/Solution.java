package day44.LeetCode2748;

public class Solution {
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (gcd(func(nums[i]), nums[j] % 10) == 1) count++;
            }
        }
        return count;
    }


    public int func(int num) {
        int res = 0;
        while (num > 0) {
            res = num % 10;
            num = num / 10;
        }
        return res;
    }

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
