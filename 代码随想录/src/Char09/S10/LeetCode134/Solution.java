package Char09.S10.LeetCode134;

//贪心算法
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //记录当前和 总和 起始位置
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            //若当前和小于0则该位置之前都不能作为起始位置
            if (curSum < 0) {
                curSum = 0;
                start = i + 1;
            }
        }
        //若总和小于0则不可能完成
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }

}
