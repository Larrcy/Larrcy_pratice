package day01.BigOperation.BigMinus;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "616";
        String res = "";
        char v=' ';
        String.valueOf(v);
        if (compare(num1, num2)) res = minusString(num1, num2);
        else {
            res += "-";
            res += minusString(num2, num1);
        }
        System.out.println(res);
    }

    public static String minusString(String num1, String num2) {
        //t充当借位
        int i = num1.length() - 1, j = num2.length() - 1, t = 0;
        StringBuilder ans = new StringBuilder();
        // 从低位到高位开始计算
        // 两位数字相减，结果要么是一位正数，要么是一位负数
        // 当结果 t>=0 时，当前位的计算结果就是t；
        // 当结果 t<0 时，需要向高位借 1，也就是当前的结算结果需要加上 10。
        // 综合起来，当前位的计算结果为 (t+10)%10
        while (i >= 0 || j >= 0 || t != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' - t : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            t = x - y;
            ans.append((t + 10) % 10);
            if (t >= 0) t = 0;
            else t = 1;
            i--;
            j--;
        }
        //去除前导0
        while (ans.length() > 1 && ans.charAt(ans.length() - 1) == '0')
            ans.deleteCharAt(ans.length() - 1);
        return ans.reverse().toString();
    }


    //判断 A B 谁大
    public static boolean compare(String A, String B) {
        int an = A.length(), bn = B.length();
        //位数不同则直接判断谁的位数大
        if (an != bn) return an > bn;
        for (int i = 0; i < an; i++) {
            //位数相同则每位都进行比较
            //从前往后进行比较
            if (A.charAt(i) != B.charAt(i)) return A.charAt(i) > B.charAt(i);
        }
        return true;
    }


}
