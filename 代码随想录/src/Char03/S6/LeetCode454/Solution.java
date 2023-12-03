package Char03.S6.LeetCode454;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }
    public String shiftingLetters(String S, int[] shifts) {
        int size = S.length();
        // 用来存储将 S 转换成字符序列的结果
        char[] s = new char[size];
        // 记录当前位置的字符需要位移的个数
        int cnt = 0;
        // 将 S 转换成字符数组，方便按照下标进行修改
        S.getChars(0, size - 1, s, 0);
        // 从后往前处理
        for (int i = size - 1; i >= 0; --i) {
            // 计算一下当前位置 i 需要位移的多少单位
            cnt += shifts[i] % 26;
            // 然后位移
            int target = S.charAt(i) - 'a' + cnt;
            // 然后修改
            s[i] = (char) ('a' + target  % 26);
        }
        // 最后再把结果换回字符串结果
        return String.valueOf(s);
    }


}
