package day64.贪心.LeetCode769;

/**
 * 给定一个长度为 n 的整数数组 arr ，它表示在 [0, n - 1] 范围内的整数的排列。
 * <p>
 * 我们将 arr 分割成若干 块 (即分区)，并对每个块单独排序。将它们连接起来后，使得连接的结果和按升序排序后的原数组相同。
 * <p>
 * 返回数组能分成的最多块数量。
 */
public class Solution {
    //由于数组中的数是0-n-1
    //因此对数组中的数进行遍历累加
    //若累加的数跟下标累加相等
    //则可以分块
    public int maxChunksToSorted(int[] arr) {
        int ret = 0;
        int vSum = 0;
        int iSum = 0;
        for (int i = 0; i < arr.length; i++) {
            vSum += arr[i];
            iSum += i;
            if (vSum == iSum) ret++;
        }
        return ret;
    }
}
