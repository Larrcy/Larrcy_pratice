package day23.LeetCode2600;

public class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes + numZeros >= k) return Math.min(k,numOnes);
        else return 2*numOnes+numZeros-k;

    }
}
