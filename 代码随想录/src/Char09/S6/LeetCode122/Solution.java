package Char09.S6.LeetCode122;

public class Solution {
    public int maxProfit(int[] prices) {
    int curDiff;
    int count =0;
    //只需统计所有上坡
        for (int i = 0; i < prices.length-1; i++) {
            curDiff=prices[i+1]-prices[i];
            if(curDiff>0){
                count=count+curDiff;
            }
        }
        return count;
    }
}
