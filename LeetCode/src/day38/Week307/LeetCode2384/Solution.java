package day38.Week307.LeetCode2384;

public class Solution {
    public static void main(String[] args) {
        String num="00000000000000444947137";
        System.out.println(largestPalindromic(num));
    }
    public static String largestPalindromic(String num) {
        int[] cnt = new int[10];
        //先统计每个数字出现了多少次
        for(char c : num.toCharArray()) {
            cnt[c - '0']++;
        }
        StringBuilder sb = new StringBuilder();
        //从后往前遍历从大到小添加前半段字符串
        for(int i = 9; i >= 0; i--) {
            while(cnt[i] >= 2) {
                cnt[i] -= 2;
                sb.append(i);
            }
        }
        //判断前导0的特殊情况 0出现次数大于2但其他数出现次数小于2如00009
        if(sb.length() > 0 && sb.charAt(0) == '0') {
            sb.setLength(0);
            for(char c : num.toCharArray()) {
                cnt[c - '0'] = 1;
            }
        }
        //将后半段记录
        String tail = new StringBuilder(sb).reverse().toString();
        //最后从后往前遍历寻找中间那个最大的值 找到则添加进去
        for(int i = 9; i >= 0; i--) {
            if(cnt[i] > 0) {
                sb.append(i);
                break;
            }
        }
        sb.append(tail);
        return sb.toString();
    }

}
