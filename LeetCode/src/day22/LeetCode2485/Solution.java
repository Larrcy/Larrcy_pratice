package day22.LeetCode2485;

public class Solution {
    public int pivotInteger(int n) {
        int sum1 =0;
        int sum2 =0;
        for (int i = 1; i <= n; i++) {
            sum1+=i;
        }
        for (int i = n; i < n+1000; i++) {
            sum2+=i;
            if(sum2>sum1){
                return -1;
            }
            if(sum2==sum1){
                return n;
            }
        }
        return -1;
    }
}
