package day04.LeetCode7;

public class Solution {
    public static void main(String[] args) {
        int x =1534236469;
        int a =214748364-1;

        System.out.println(reverse(x));
    }
    public static int reverse(int x) {

        long sum =0;
        while (x!=0){
            sum=sum*10+x%10;
            x=x/10;
        }
        if(sum<-Integer.MIN_VALUE||sum>Integer.MAX_VALUE){
            return 0;
        }

        return (int) sum;
    }
}
