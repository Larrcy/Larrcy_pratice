package day15.LeetCode495;

public class Solution {
    public static void main(String[] args) {
        int[]timeSeries={1,2,3,4,5};
        int duration =5;
        System.out.println(findPoisonedDuration(timeSeries, duration));

    }
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length==1){
            return duration;
        }
        int p=0 ;
        int q=1 ;
        int sum =0;
        for (; p < timeSeries.length; p++,q++) {
            if(timeSeries[p]+duration<=timeSeries[q]){
                sum=sum+duration;
            }else {
                sum=sum-timeSeries[p]+timeSeries[q];
            }
            if(q==timeSeries.length-1){
                sum=sum+duration;
                break;
            }
        }
        return sum;
    }
}
