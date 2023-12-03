package day01.BigOperation.Multiply;

public class Solution {
    public static void main(String[] args) {
        String num1 = "0";
        int num2 = 111;
        System.out.println(MultiplyString(num1, num2));
    }

    // 高精度 * 低精度：A * b
    public static String MultiplyString(String num1, int num2) {
        //特判0的情况
        if (num1 .equals("0") || num2 == 0) return "0";
        int i = num1.length() - 1, t = 0;
        StringBuilder ans = new StringBuilder();
        // t 表示进位
        while (i >= 0 ||  t != 0) {
            // 获得当前位的乘积和
            if (i >= 0)
                t += (num1.charAt(i) - '0') *num2;
            // 获取个位
            ans.append(t % 10);
            //保留进位
            t /= 10;
            i--;
        }
        // 删除前导0
        while (ans.length() > 1 && ans.charAt(ans.length() - 1) == '0')
            ans.deleteCharAt(ans.length() - 1);
        return ans.reverse().toString();
    }
}
