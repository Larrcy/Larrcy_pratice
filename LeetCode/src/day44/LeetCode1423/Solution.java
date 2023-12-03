package day44.LeetCode1423;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] cardPoints = {1, 9, 1, 2};
        int k = 2;
        maxScore(cardPoints, k);
    }

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + cardPoints[i - 1];
        }

        int x;
        int res = 0;
        for (int i = 0; i <= k; i++) {
            x = (sum[i] + sum[sum.length - 1] - sum[sum.length - (k - i) - 1]);
            res = Math.max(x, res);
        }

        return res;

    }
}
