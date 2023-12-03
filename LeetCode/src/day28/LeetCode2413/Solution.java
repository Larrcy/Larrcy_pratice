package day28.LeetCode2413;

public class Solution {
    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) return n;
        else return n * 2;
    }
}
