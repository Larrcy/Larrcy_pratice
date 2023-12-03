package day64.贪心.LeetCode2844;

/**
 * 给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
 *
 * 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。
 *
 * 返回最少需要多少次操作可以使 num 变成特殊数字。
 *
 * 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
 */
public class Solution {
    private int ans;
//一个数能被 25 整除，有如下五种情况：
//这个数是 0。
//这个数的末尾是 00。
//这个数的末尾是 25。
//这个数的末尾是 50。
//这个数的末尾是 75。
//首先，根据题目说的，我们可以把 num 中的所有数字都删除，得到 0，这需要删除 n 次。
//但如果 num 中有 0，那么删除 n−1 也可以得到0

    //以 50 为例说明：
    //从右到左遍历 num，找到第一个 0。
    //继续向左遍历，找到第一个 5，设其下标为 i。
    //删除这个 5 右侧的所有非 0 数字，这样就得到了一个以 50 结尾的数字。
    //删除次数为 n−i−2
    // 例如示例 1 中 5 的下标是 i=3，需要删除 7−3−2=2 次。
    public int minimumOperations(String num) {
        ans = num.length();
        if (num.contains("0"))
            ans--;
        f(num, "00");
        f(num, "25");
        f(num, "50");
        f(num, "75");
        return ans;
    }

    private void f(String num, String tail) {
        int n = num.length();
        int i = num.lastIndexOf(tail.charAt(1));
        if (i < 0) return;
        i = num.lastIndexOf(tail.charAt(0), i - 1);
        if (i < 0) return;
        ans = Math.min(ans, n - i - 2);
    }

}
