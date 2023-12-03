package day21.LeetCode852;

import java.util.Arrays;
import java.util.OptionalInt;

public class Solution {
    public static void main(String[] args) {
        int[]arr ={24,69,100,99,79,78,67,36,26,19};
        System.out.println(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        for (int i = 0; i < arr.length; i++) {
            if(max==arr[i])return i;
        }
        return -1;
    }
}
