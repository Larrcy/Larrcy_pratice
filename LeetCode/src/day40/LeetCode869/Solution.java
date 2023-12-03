package day40.LeetCode869;

public class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] index = new int[30];
        for (int i = 0; i < index.length; i++) {
            index[i] = (int) Math.pow(2, i);
        }
        for (int i = 0; i < index.length; i++) {
            if (n == index[i]) return true;
        }
        return false;
    }
}
