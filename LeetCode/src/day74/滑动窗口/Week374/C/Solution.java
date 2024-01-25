package day74.滑动窗口.Week374.C;

/**
 * 给你一个字符串 word 和一个整数 k 。
 * <p>
 * 如果 word 的一个子字符串 s 满足以下条件，我们称它是 完全字符串：
 * <p>
 * s 中每个字符 恰好 出现 k 次。
 * 相邻字符在字母表中的顺序 至多 相差 2 。也就是说，s 中两个相邻字符 c1 和 c2 ，它们在字母表中的位置相差 至多 为 2 。
 * 请你返回 word 中 完全 子字符串的数目。
 * <p>
 * 子字符串 指的是一个字符串中一段连续 非空 的字符序列。
 */
public class Solution {
    //分组循环+滑动窗口
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int ans = 0;
        //分组循环用于解决分割成若干组的数组，对于每个数组他们的处理逻辑一样的情况
        //首先利用分组循环来找到每一组的起始位置和结束位置
        //下一组的起始位置是i
        //因此只需要判断word.charAt(i) - word.charAt(i - 1)这两个字符之差是否<=2
        //下面套用分组循环模板
        int i = 0;
        while (i < n) {
            int start = i;
            i++;
            while ( i < n && Math.abs(word.charAt(i) - word.charAt(i - 1)) <= 2) {
                i++;

            }
            //接下来保证s中每个字符恰好出现k次
            ans += f(word.substring(start, i), k);
        }

        return ans;
    }

    //统计每个字符的出现次数
    private int f(String s, int k) {
        char[] chars = s.toCharArray();
        int res = 0;
        //滑动窗口的大小是确定的为 k*m 即每个字符出现的个数*不同的字符数
        for (int m = 1; m <= 26 && k * m <= chars.length; m++) {
            int[] cnt = new int[26];
            //滑动窗口
            for (int right = 0; right < chars.length; right++) {
                //始终保持窗口大小为k*m
                //即right-left+1=k*m
                // left = right + 1 - k * m
                int left = right + 1 - k * m;
                cnt[chars[right] - 'a']++;
                if (left >= 0) {
                    //对于窗口内的元素进行判断每个字符的出现次数是否为k
                    boolean flag = true;
                    for (int i = 0; i < 26; i++) {
                        if (cnt[i] > 0 && cnt[i] != k) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) res++;
                    cnt[chars[left] - 'a']--;
                }
            }
        }
        return res;
    }

}
