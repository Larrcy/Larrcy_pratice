package day44.LeetCode941;

public class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int index = arr.length;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) return false;
            if (arr[i] > arr[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == arr.length) return false;
        for (int i = index; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) return false;
        }
        return true;
    }
}
