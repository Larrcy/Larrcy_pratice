package day28.LeetCode1894;

public class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long count = 0;
        for (int i = 0; i < chalk.length; i++) {
            count += chalk[i];
        }
        count =  k%count;
        for (int i = 0; i < chalk.length; i++) {
            count-=chalk[i];
            if (count<= 0) {
                return i;
            }
        }
        return -1;
    }
}
