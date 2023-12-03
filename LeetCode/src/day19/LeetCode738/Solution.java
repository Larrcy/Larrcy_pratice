package day19.LeetCode738;

class Solution {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        //获取每一位数
        char[] chars = s.toCharArray();
        //从后往前遍历
        //定义s.length()保证没有9的情况
        int start = s.length();
        for (int i = s.length() - 1; i > 0; i--) {
            if (chars[i-1] > chars[i]) {
                chars[i-1]--;
                //记录从i往后的元素 都要变成9
                start = i;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        //最后转成int类型
        return Integer.parseInt(String.valueOf(chars));
    }
}