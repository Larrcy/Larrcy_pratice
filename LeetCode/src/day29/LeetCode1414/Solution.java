package day29.LeetCode1414;

public class Solution {
    public int findMinFibonacciNumbers(int k) {
        int[] F = new int[46];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <=45; i++) {
            F[i]=F[i-1]+F[i-2];
        }
        int count =0;
        for (int i = F.length-1; i>=0 ; i--) {
            if(k>F[i]){
                k-=F[i];
                count++;
            }
            if(k==0)
                return count;

        }
        return -1;

    }
}
