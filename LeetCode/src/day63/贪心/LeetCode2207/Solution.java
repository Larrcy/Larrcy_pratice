package day63.贪心.LeetCode2207;

/**
 * 给你一个下标从 0 开始的字符串 text 和另一个下标从 0 开始且长度为 2 的字符串 pattern ，两者都只包含小写英文字母。
 * <p>
 * 你可以在 text 中任意位置插入 一个 字符，这个插入的字符必须是 pattern[0] 或者 pattern[1] 。注意，这个字符可以插入在 text 开头或者结尾的位置。
 * <p>
 * 请你返回插入一个字符后，text 中最多包含多少个等于 pattern 的 子序列 。
 * <p>
 * 子序列 指的是将一个字符串删除若干个字符后（也可以不删除），剩余字符保持原本顺序得到的字符串。
 */
public class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        //a为前一个字符，b为后一个字符，如果相同，统计字符出现次数，按照等差数列求和
        //否则，从后往前遍历，边遍历边统计a，b出现的次数，每次出现a都可以加上b已经出现的次数
        //贪心：加入a字符加到最前面，这样后面的b出现次数最多，加入b字符加到最后面，这样前面的a出现次数最多
        char a = pattern.charAt(0), b = pattern.charAt(1);
        long ans = 0;
        int aCnt = 0, bCnt = 0;
        //统计a,b出现次数
        for (int i = text.length() - 1; i >= 0; --i) {
            if (text.charAt(i) == a) {
                ++aCnt;
                ans += bCnt;
            } else if (text.charAt(i) == b) {
                ++bCnt;
            }
        }
        //特判pattern全相等的情况
        if (a == b) {
            //所有字符都一样，加入一个a字符后，每个字符都能和后面的所有字符配对
            //如aaa
            //添加一个a
            //得aaaa 其次数为等差数列求和 即(4*3)/2
            long cnt = aCnt + bCnt + 1;
            return ((cnt - 1) + 1) * (cnt - 1) / 2;
        }

        ans += Math.max(aCnt, bCnt);
        return ans;
    }
}
