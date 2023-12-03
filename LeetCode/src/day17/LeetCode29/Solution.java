package day17.LeetCode29;

public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==0)return 0;
        long res=0;
    if(dividend>0&&divisor>0){
        while (dividend>=0){
            dividend=dividend-divisor;
            res++;
        }
    }
        if(dividend>0&&divisor<0){
            while (dividend>=0){
                dividend=dividend+divisor;
                res--;
            }
        }
        if(dividend<0&&divisor>0){
            while (dividend>=0){
                dividend=dividend+divisor;
                res--;
            }
        }
        if(dividend<0&&divisor<0){
            while (dividend<=0){
                dividend=dividend-divisor;
                res++;
            }
        }
        if(res>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }if(res<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        else return (int) res;
    }
}
