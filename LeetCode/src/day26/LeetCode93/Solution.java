package day26.LeetCode93;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public LinkedList<String> res = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return res;
        backtracking(s, 0, 0);
        return res;
    }

    public void backtracking(String s, int startIndex, int pointSum) {
        //保证ip合法 则点为3个
        if (pointSum == 3) {
            //对最后一段进行合法判断
            if (isValid(s, startIndex, s.length() - 1)) {
                res.add(s);
                return;
            }
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                //合法则添加网段
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);    //在str的后⾯插⼊⼀个逗点
                pointSum++;

                //将点也要加上故为i+2
                backtracking(s, i + 2, pointSum);
                pointSum--;
                //不合法则删除网段进行回溯
                //将添加的点也要删除
                s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点还原s之前的状态
            } else break;
        }

    }

    //判断子串是否合法 左闭右闭
    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
