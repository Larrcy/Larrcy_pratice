package day01.BigOperation.BigSum;

public class Solution {
    public static void main(String[] args) {
        String num1 ="1";
        String num2 ="999";

        System.out.println(addStrings(num1, num2));
    }
    public static String addStrings(String num1, String num2) {
        //从后往前遍历进行竖式相加
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        //字符串拼接
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            //竖式相加法 判断各位相加 并判断是否有进位
            //位数不够则为0
            //最后也要对进位进行判断 若x y都为0 但进位不为0
            //要单独将进位加上
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            //获得进位
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        return ans.reverse().toString();
    }
}
