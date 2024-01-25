package day86.LeetCode466;

import java.util.*;

/**
 * 定义 str = [s, n] 表示 str 由 n 个字符串 s 连接构成。
 * <p>
 * 例如，str == ["abc", 3] =="abcabcabc" 。
 * 如果可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。
 * <p>
 * 例如，根据定义，s1 = "abc" 可以从 s2 = "abdbec" 获得，仅需要删除加粗且用斜体标识的字符。
 * 现在给你两个字符串 s1 和 s2 和两个整数 n1 和 n2 。由此构造得到两个字符串，其中 str1 = [s1, n1]、str2 = [s2, n2] 。
 * <p>
 * 请你找出一个最大整数 m ，以满足 str = [str2, m] 可以从 str1 获得。
 */
public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        //从str1中找s2的出现次数 ans 最后返回ans/n2即可
        if (n1 == 0) return 0;
        //找str1与s2相匹配的循环节
        //最后转化成 前+循环节*n+不能匹配后的形式
        int index = 0;
        //s1出现次数
        int s1cnt = 0;
        //s2出现次数
        int s2cnt = 0;
        // recall 是我们用来找循环节的变量，它是一个哈希映射
        Map<Integer, int[]> recall = new HashMap<Integer, int[]>();
        //cnt1用来记录循环节之前包含了多少s1和s2
        int[] cnt1;
        //cnt2用来记录一个循环节中包含了多少s1和s2
        int[] cnt2;
        while (true) {
            s1cnt++;
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                if (s2.charAt(index) == c) {
                    index++;
                    if (index == s2.length()) {
                        s2cnt++;
                        index = 0;
                    }
                }
            }
            //若还没找到循环节 s1就已经用完
            if (s1cnt == n1) {
                //返回s2出现次数
                return s2cnt / n2;
            }
            //找到循环节
            if (recall.containsKey(index)) {
                int[] val = recall.get(index);
                int s1Pre = val[0];
                int s2Pre = val[1];
                cnt1 = new int[]{s1Pre, s2Pre};
                cnt2 = new int[]{s1cnt - s1Pre, s2cnt - s2Pre};
                break;

            } else {
                recall.put(index, new int[]{s1cnt, s2cnt});
            }
        }
        int ans = cnt1[1] + (n1 - cnt1[0]) / cnt2[0] * cnt2[1];
        //遍历还剩下的s1中包含多少个s2
        int remain = (n1 - cnt1[0]) % cnt2[0];
        for (int i = 0; i < remain; i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s2.charAt(index) == s1.charAt(j)) {
                    index++;
                    if (index == s2.length()) {
                        index = 0;
                        ans++;
                    }
                }
            }
        }

        return  ans/n2;
    }
}
