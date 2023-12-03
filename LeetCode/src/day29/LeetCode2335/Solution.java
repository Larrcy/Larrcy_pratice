package day29.LeetCode2335;

import java.util.Arrays;

public class Solution {
    public int fillCups(int[] amount) {
        int count = 0;
        Arrays.sort(amount);
        if (amount[1] == 0) {
            return count + amount[2];
        }

        do {
            Arrays.sort(amount);
            amount[1]--;
            amount[2]--;
            count++;
            Arrays.sort(amount);
        } while (amount[1] != 0);
        return count + amount[2];
    }
}
