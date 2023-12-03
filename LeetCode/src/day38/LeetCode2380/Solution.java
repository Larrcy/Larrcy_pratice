package day38.LeetCode2380;

public class Solution {
    public static void main(String[] args) {
        System.out.println(secondsToRemoveOccurrences("0110101"));
    }
    public static int secondsToRemoveOccurrences(String s) {
     int count =0;
        while (s.contains("01")) {
            s = s.replace("01", "10");
            count++;
        }

        return count;
    }
}
