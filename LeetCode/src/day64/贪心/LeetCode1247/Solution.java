package day64.贪心.LeetCode1247;

/**
 * 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 *
 * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 *
 * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
 *
 * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 */
public class Solution {
    public int minimumSwap(String s1, String s2) {
        int[] cnt = new int[2];
        for (int i = 0, n = s1.length(); i < n; ++i)
            //统计s1[i]!= s2[i]的对数d
            //若d为奇数则无法交换后使s1=s2
            //若d为偶数
            //1.若x，y均为偶数则两两一对进行交换答案为d/2
            //2.若x，y均为奇数则多余1对将其加到结果即可
            if (s1.charAt(i) != s2.charAt(i))
                ++cnt[s1.charAt(i) % 2]; // x 和 y ASCII 值的二进制最低位不同
        int d = cnt[0] + cnt[1];
        return d % 2 != 0 ? -1 : d / 2 + cnt[0] % 2;
    }

}
