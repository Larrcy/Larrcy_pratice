package day21.LeetCode1534;

public class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count =0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                for (int k = 2; k < arr.length; k++) {
                    if(Math.abs(arr[i]-arr[j])<=a&&Math.abs(arr[j]-arr[k])<=b&&Math.abs(arr[i]-arr[k])<=c)
                count++;
                }
            }
        }
        return count;
    }
}
