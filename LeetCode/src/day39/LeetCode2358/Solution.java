package day39.LeetCode2358;

public class Solution {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int index = 1;
        int count = 0;
        while (n != 0) {
            n -= index;
            index++;
            count++;
        }
        return count;
    }
}
