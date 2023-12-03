package day28.LeetCode2579;

public class Solution {
    public long coloredCells(int n) {
        int sum =0;
        for (int i = 0; i <n; i++) {
            sum+=(int)Math.pow(4,i);
        }
        return sum;
    }
}
