package day36.AC.LeetCode2269;

public class Solution {
    public int divisorSubstrings(int num, int k) {
        char[] chars = Integer.toString(num).toCharArray();
        int n = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            n = n * 10 + (chars[i] - '0');
        }
        if (n != 0 && num % n == 0) count++;
        for (int i = k; i < chars.length; i++) {
            n = n - (chars[i - k] - '0') * (int) Math.pow(10, (k - 1));
            n = n * 10 + (chars[i] - '0');
            if (n != 0 && num % n == 0) count++;
        }
        return count;
    }
}
