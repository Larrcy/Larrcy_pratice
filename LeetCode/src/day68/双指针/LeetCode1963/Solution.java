package day68.双指针.LeetCode1963;

/**
 给你一个字符串 s ，下标从 0 开始 ，且长度为偶数 n 。字符串 恰好 由 n / 2 个开括号 '[' 和 n / 2 个闭括号 ']' 组成。

 只有能满足下述所有条件的字符串才能称为 平衡字符串 ：

 字符串是一个空字符串，或者
 字符串可以记作 AB ，其中 A 和 B 都是 平衡字符串 ，或者
 字符串可以写成 [C] ，其中 C 是一个 平衡字符串 。
 你可以交换 任意 两个下标所对应的括号 任意 次数。

 返回使 s 变成 平衡字符串 所需要的 最小 交换次数。

 */
public class Solution {
    //遍历字符串s的每个位置当左括号的数量大于等于右括号的数量才能平衡
    int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int left = 0, right = 0;
        for (char i : chars) {
            //统计左右括号的数量
            if (i == '[') {
                left++;
            } else {
                right++;
            }
            //若出现右括号大于左括号的情况
            //则说明要发生一次交换
            //同时改变当前左右括号的数量
            //即左括号+1右括号-1
            if (right > left) {
                res++;
                left++;
                right--;
            }
        }
        return res;

    }
}




