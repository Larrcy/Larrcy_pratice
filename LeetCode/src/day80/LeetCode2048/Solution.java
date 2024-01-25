package day80.LeetCode2048;

/**
 * 如果整数  x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。
 *
 * 给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。
 */
public class Solution {
    public int nextBeautifulNumber(int n) {
        //n的范围为0-10^6因此最大的数值平衡树为1224444
        //枚举n+1到1224444范围内所有满足数值平衡数的数
        for (int i = n + 1; i <= 1224444; ++i) {
            if (isBalance(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isBalance(int x) {
        //记录每一位数位
        int[] count = new int[10];
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        //遍历数位看是否满足数值平衡数的条件
        for (int d = 0; d < 10; ++d) {
            if (count[d] > 0 && count[d] != d) {
                return false;
            }
        }
        return true;
    }

}
