package day27.LeetCode1846;

import java.util.Arrays;

public class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if(arr[0]!=1)arr[0]=1;
        for (int p = 0, q = 1; q < arr.length; q++, p++) {
            if (arr[q] - arr[p] > 1) {
                arr[q] = arr[p] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}
