package day68.双指针.LeetCode2472;

public class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] f = new int[n + 1];
        for (int i = 0; i < 2 * n - 1; i++) {
            // 更加优雅的方式枚举所有奇数和偶数的中心点位置
            int l = i / 2, r = l + i % 2;
            // s[l]不包含在回文串中
            f[l + 1] = Math.max(f[l + 1], f[l]);
            for (; l >= 0 && r < n && s.charAt(l) == s.charAt(r); --l, ++r) {
                if (r - l + 1 >= k) { // 贪心处理，f[l]是非递减的，更小的f[l]也不会影响答案
                    // s[r]包含在回文串中，并且回文长度大于等于k
                    f[r + 1] = Math.max(f[r + 1], f[l] + 1);
                }
            }
        }
        return f[n];
    }
}
