package day67.LeetCode2429;

/**
 *给你两个正整数 num1 和 num2 ，找出满足下述条件的整数 x ：
 *
 * x 的置位数和 num2 相同，且
 * x XOR num1 的值 最小
 * 注意 XOR 是按位异或运算。
 *
 * 返回整数 x 。题目保证，对于生成的测试用例， x 是 唯一确定 的。
 *
 * 整数的 置位数 是其二进制表示中 1 的数目。
 */
class Solution {


    public int minimizeXor(int num1, int num2) {
        //bitcount 计算num中1的个数
        int c1 = Integer.bitCount(num1);
        int c2 = Integer.bitCount(num2);
        //若c2的1比c1的小
        //从左到右依次匹配num1的1后面补齐0
        //等价于从右到左把num1的1变成0 (c2-c1)次
        //num1 &= num1 - 1即表示 最低的 1 变成 0
        //若c2大于c1
        //在从右到左匹配完所有的1之后还有剩余的1
        //则从右到左匹配num1的0 将这些0变成1
        for (; c2 < c1; ++c2) num1 &= num1 - 1;
        for (; c2 > c1; --c2) num1 |= num1 + 1; // 最低的 0 变成 1
        return num1;
    }
}