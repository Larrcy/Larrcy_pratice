package day01.BigOperation.Division;

public class Solution {
    public static void main(String[] args) {
        String num1 = "164";
        int num2 = 7;
        System.out.println(divisionStrings(num1, num2));
    }

    public static String divisionStrings(String num1, int num2) {
        if (num1.equals("0")) return "0";
        // t 表示余数
       int t = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < num1.length(); i++) {
            t=t*10+num1.charAt(i)-'0';
            ans.append(t/num2);
            t%=num2;
        }
        // 删除前导0
        while (ans.length() > 1 && ans.charAt(0) == '0')
            ans.deleteCharAt(0);
        return ans+" "+t;
    }
}
