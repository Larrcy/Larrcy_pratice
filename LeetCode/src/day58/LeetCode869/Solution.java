package day58.LeetCode869;

import java.util.Arrays;

public class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] res = new int[31];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) Math.pow(2, i);
        }
        char[] num = Integer.toString(n).toCharArray();
        int[] count = new int[10];
        for (int i = 0; i < num.length; i++) {
            count[num[i] - '0']++;
        }
        for (int i = 0; i < res.length; i++) {
            char[] temp = Integer.toString(res[i]).toCharArray();
            int[] count2 = new int[10];
            for (int j = 0; j < temp.length; j++) {
                count2[temp[j] - '0']++;
            }
            if (Arrays.equals(count2, count)) {
                return true;
            }
        }
        return false;
    }
}
