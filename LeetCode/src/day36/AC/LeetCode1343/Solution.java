package day36.AC.LeetCode1343;

public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int count = 0;
        int sum = 0;
        int res = 0;
        for (int right = 0; right < arr.length;) {
            while (count < k) {
                sum += arr[right];
                right++;
                count++;
            }
            if ((double) sum / k >= threshold) res++;
            if (count == k) {
                sum -= arr[left];
                left++;
                count--;
            }
        }
        return res;
    }
}
