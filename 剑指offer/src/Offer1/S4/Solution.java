package Offer1.S4;

public class Solution {
    public int strToInt(String str) {
        // 去除首尾空白
        str = str.trim();
        // 特殊值处理
        if (str == null || str.length() == 0) {
            return 0;
        }
        // 正常情况
        char first = str.charAt(0);
        int sign = 1;   // 标记符号位
        int i = 1;      // 遍历开始位置，若首位为符号，则从1开始，否则从0开始
        if (first == '-') {
            sign = -1;
        } else if (first != '+') {
            // 首位为数字
            i = 0;
        }
        // 开始遍历
        int res = 0;
        for (int j = i; j < str.length(); j++) {
            if (str.charAt(j) < '0' || str.charAt(j) > '9') {
                // 非数字,跳出循环
                break;
            }
            // temp / 10 != temp * 10：则表明发生了数字溢出（加的值会被舍去）
            int temp = res * 10 + (str.charAt(j) - '0');
            if (temp / 10 != res) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = temp;
        }
        return sign * res;
    }
}
