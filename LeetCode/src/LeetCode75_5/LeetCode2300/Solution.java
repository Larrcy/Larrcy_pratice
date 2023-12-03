package LeetCode75_5.LeetCode2300;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] spells = {3, 1, 2};
        int[] potions = {8, 5, 8};
        long success = 16;
        System.out.println(successfulPairs(spells, potions, success));
    }

        public static int[] successfulPairs(int[] spells, int[] potions, long success) {
            Arrays.sort(potions);
            int m = spells.length;
            int n = potions.length;
            int[] res = new int[m];

            int i = 0;
            while (i < m) {
                long spell =  spells[i];
                int left = 0;
                int right = n;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (spell * potions[mid] < success) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                res[i] = n - left;
                i++;
            }
            return res;
        }
}
