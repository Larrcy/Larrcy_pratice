package Char09.S12.LeetCode135;

public class Solution {
    public int candy(int[] ratings) {
        int []candy =new int[ratings.length];
        //右边比左边大的情况
        for (int i = 1; i < candy.length; i++) {
            if(ratings[i]>ratings[i-1]){
                candy[i]=candy[i-1]+1;
            }
        }
        //左边比右边大的情况
        for (int i = candy.length-2; i >=0; i--) {
            if(ratings[i]>ratings[i+1]){
                //要保证既要比左边大又要比右边大故取最大值
                candy[i]=Math.max(candy[i+1]+1,candy[i]);
            }
        }
        //统计糖果数量
        int sum =candy.length;
        for (int i = 0; i < candy.length; i++) {
            sum+=candy[i];
        }
        return sum;
    }
}
