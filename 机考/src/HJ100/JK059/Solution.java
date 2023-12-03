package HJ100.JK059;

import java.util.Scanner;

//简易压缩算法
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(func(s));
    }

    public static String func(String s) {
        if (!(s.charAt(s.length() - 1) >= 'a' && s.charAt(s.length() - 1) <= 'z')) {
            return "!error";
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (!((s.charAt(i) >= '3' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z'))) {
                return "!error";
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String num = "";
            while (s.charAt(i) >= '3' && s.charAt(i) <= '9') {
                num += s.charAt(i);
                i++;
            }
            if (num.equals("")) {
                sb.append(s.charAt(i));
            } else {
                for (int j = 0; j < Integer.parseInt(num); j++) {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
