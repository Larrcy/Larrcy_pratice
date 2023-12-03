package day09.LeetCode415;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws UnsupportedEncodingException {

      String num1 ="-9";
      String num2 ="-1";
        System.out.println(addStrings(num1, num2));
    }
    public static String addStrings(String num1, String num2) {
        String p="";
        if(num1.startsWith("-")&&num2.startsWith("-")){
            num1=num1.substring(1);
            num2=num2.substring(1);
            p=p+"-";
        }
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;



        //字符串拼接
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            //竖式相加法 判断各位相加 并判断是否有进位
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            //获得进位
            add = result / 10;
            i--;
            j--;
        }
        ans.append(p);
        // 计算完翻转
        ans.reverse();
        return ans.toString();
    }

}
