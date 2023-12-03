package day71.分组循环.LeetCode828;

import java.util.Arrays;

/**
 * 我们定义了一个函数 countUniqueChars(s) 来统计字符串 s 中的唯一字符，并返回唯一字符的个数。
 *
 * 例如：s = "LEETCODE" ，则其中 "L", "T","C","O","D" 都是唯一字符，因为它们只出现一次，所以 countUniqueChars(s) = 5 。
 *
 * 本题将会给你一个字符串 s ，我们需要返回 countUniqueChars(t) 的总和，其中 t 是 s 的子字符串。输入用例保证返回值为 32 位整数。
 *
 * 注意，某些子字符串可能是重复的，但你统计时也必须算上这些重复的子字符串（也就是说，你必须统计 s 的所有子字符串中的唯一字符）。
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(uniqueLetterString("BC"));
    }
    //以 s[i]结尾的子串，可以看成是以 s[i−1]结尾的子串，在末尾添加上 s[i]组成。
    //上面提示是思考子串统计类问题的通用技巧之一。

    //以 s=BCADEAFGA为例，当遍历到最后一个A 时：
    //A可以单独作为一个子串，其 countUniqueChars 值为 1；
    //往子串 G和 FG的末尾添加 A，由于 A不在这些子串中，因此这些子串的 countUniqueChars 值都会增加 111；
    //往子串 AFG、EAFG 和 DEAFG 的末尾添加 A，
    //由于 A 已经在这些子串中且恰好出现一次，添加后 A 重复出现，
    //因此这些子串的 countUniqueChars 值都会减少 1；
    //往子串 ADEAFG CADEAFG 和 BCADEAFG 的末尾添加 A，
    //由于 A 已经在这些子串中且不止出现一次，因此添加 A不会改变这些子串的 countUniqueChars 值。
    //因此我们在从左往右遍历 s 的同时，对每个字母 s[i]记录其上一次出现的下标 last0[s[i]]和上上一次出现的下标 last1[s[i]]
    //通过上面的例子，我们可以算出从「以 s[i−1]结尾的子串」到「以 s[i]结尾的子串」，countUniqueChars 值的和，增加/减少了多少：
    //考虑子串的左端点情况
    //若子串的左端点在【last0[s[i]]+1,i】则s[i]唯一出现此时唯一字符的出现次数就为【last0[s[i]]+1,i】的区间长度
    //即i-last0[s[i]]
    //若子串的左端点在【last1[s[i]]+1,last0[s[i]]】此时同一个字符会出现2次故要减少这段区间的长度
    //即last0[s[i]]-last1[s[i]]
    //故可写出状态转移方程f[i]=f[i-1]+i-last0[s[i]]-(last0[s[i]]-last1[s[i]])
    public static int uniqueLetterString(String s) {
        int ans = 0, total = 0;
        int[] last0 = new int[26], last1 = new int[26];
        Arrays.fill(last0, -1);
        Arrays.fill(last1, -1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            // total 维护「以 s[i]结尾的子串的 countUniqueChars 值的和」
            total += i - 2 * last0[c] + last1[c];
            //ans用来收集每次增加的值
            ans += total;
            last1[c] = last0[c];
            last0[c] = i;
        }
        return ans;
    }


}
