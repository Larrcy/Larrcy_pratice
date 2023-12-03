package day63.贪心.LeetCode2310;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你两个整数 num 和 k ，考虑具有以下属性的正整数多重集：
 *
 * 每个整数个位数字都是 k 。
 * 所有整数之和是 num 。
 * 返回该多重集的最小大小，如果不存在这样的多重集，返回 -1 。
 *
 * 注意：
 *
 * 多重集与集合类似，但多重集可以包含多个同一整数，空多重集的和为 0 。
 * 个位数字 是数字最右边的数位。
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(minimumNumbers(10, 5));
    }

    public static int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        if (k > num) return -1;
        if (k == num || num % 10 == k) return 1;
        int temp = 0;
        for (int i = 1; i <= 10; i++) {
            if ((i * k) % 10 == num % 10) {
                if (i * k > num) return -1;
                temp = i;
                break;
            }
        }
        return temp == 0 ? -1 : temp;
    }
}
