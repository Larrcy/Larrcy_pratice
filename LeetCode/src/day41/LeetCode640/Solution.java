package day41.LeetCode640;

public class Solution {
    public String solveEquation(String s) {
        //都是放在左边进行统计 计算x时要变号
        int x = 0, num = 0, n = s.length();
        char[] cs = s.toCharArray();
        //利用op来表示正负
        for (int i = 0, op = 1; i < n; ) {
            if (cs[i] == '+') {
                op = 1;
                i++;
            } else if (cs[i] == '-') {
                op = -1;
                i++;
            } else if (cs[i] == '=') {
                x *= -1;
                num *= -1;
                op = 1;
                i++;
            } else {
                int j = i;
                while (j < n && cs[j] != '+' && cs[j] != '-' && cs[j] != '=') j++;
                //若最后1位为x则为x的系数
                //看j是否移动过没移动过则只有1个x其系数设为1
                if (cs[j - 1] == 'x') x += (i < j - 1 ? Integer.parseInt(s.substring(i, j - 1)) : 1) * op;
                else num += Integer.parseInt(s.substring(i, j)) * op;
                i = j;
            }
        }
        if (x == 0) return num == 0 ? "Infinite solutions" : "No solution";
        else return "x=" + (num / x);
    }

}
