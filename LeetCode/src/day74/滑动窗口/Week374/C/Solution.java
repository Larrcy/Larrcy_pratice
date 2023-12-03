package day74.滑动窗口.Week374.C;

/**
 * 给你一个字符串 word 和一个整数 k 。
 *
 * 如果 word 的一个子字符串 s 满足以下条件，我们称它是 完全字符串：
 *
 * s 中每个字符 恰好 出现 k 次。
 * 相邻字符在字母表中的顺序 至多 相差 2 。也就是说，s 中两个相邻字符 c1 和 c2 ，它们在字母表中的位置相差 至多 为 2 。
 * 请你返回 word 中 完全 子字符串的数目。
 *
 * 子字符串 指的是一个字符串中一段连续 非空 的字符序列。
 */
public class Solution {
    //分组循环+滑动窗口
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int ans = 0;
        //首先利用分组循环来找到每一组的起始位置和结束位置
        //下一组的起始位置是i
        //因此只需要判断word.charAt(i) - word.charAt(i - 1)这两个字符之差是否<=2
        for (int i = 0; i < n; ) {
            int st = i;
            for (i++; i < n && Math.abs(word.charAt(i) - word.charAt(i - 1)) <= 2; i++) ;
            ans += f(word.substring(st, i), k);
        }
        return ans;
    }
//统计每个字符的出现次数
    private int f(String S, int k) {
        char[] s = S.toCharArray();
        int res = 0;
        for (int m = 1; m <= 26 && k * m <= s.length; m++) {
            int[] cnt = new int[26];
            for (int right = 0; right < s.length; right++) {
                cnt[s[right] - 'a']++;
                int left = right + 1 - k * m;
                if (left >= 0) {
                    boolean ok = true;
                    for (int i = 0; i < 26; i++) {
                        if (cnt[i] > 0 && cnt[i] != k) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) res++;
                    cnt[s[left] - 'a']--;
                }
            }
        }
        return res;
    }

}
