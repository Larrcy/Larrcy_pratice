package day21.LeetCode258;

import java.util.Arrays;

public class Solution {
    public int addDigits(int num) {
        if (num / 10 == 0) return num;
        while (num >= 10) {
            int res = 0;
            while (num != 0) {
                res += num % 10;
                num = num / 10;

            }
            num=res;

        }
        return num;
    }
}
