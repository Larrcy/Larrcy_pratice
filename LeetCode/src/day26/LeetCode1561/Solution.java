package day26.LeetCode1561;

import java.util.Arrays;

public class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int count = piles.length / 3;
        int sum = 0;
        for (int i = piles.length - 2; i >= 0; i-=2) {
                sum += piles[i];
                count--;
            if (count == 0) break;
        }
        return sum;
    }
}
