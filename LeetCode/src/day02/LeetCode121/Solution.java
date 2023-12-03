package day02.LeetCode121;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public  static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                //获取最小值
                minprice = prices[i];
            }
            //获取第i天能获得的利润（不考虑之前）
            else if (prices[i] - minprice > maxprofit) {
                //获取最大利润
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

}




