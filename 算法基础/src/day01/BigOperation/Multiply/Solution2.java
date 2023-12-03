package day01.BigOperation.Multiply;

public class Solution2 {
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(BigMultiplyString(num1, num2));
    }

    public static String BigMultiplyString(String num1, String num2) {
        int n = num1.length(), m = num2.length();
        //m位与n位相乘 最多可得到m+n位的数
        //用res来记录相乘所得的结果
        int[] res = new int[n + m];
        //竖式乘法
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int r = a * b;
                r += res[i + j + 1];
                //保留当前位即计算结果的个位
                res[i + j + 1] = r % 10;
                //更新进位值
                res[i + j] += r / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            if (sb.length() == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

}


