package HJ100.JK094;

import java.util.Scanner;

//字符串加密
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.nextLine();
        }
        String[] func = func(str);
        for (int i = 0; i < func.length; i++) {
            System.out.println(func[i]);
        }
    }

    public static String[] func(String[] str) {
        String[] res = new String[str.length];
        long[] a = new long[50];
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        for (int i = 3; i < 50; i++) {
            a[i] = a[i - 1] + a[i - 2] + a[i - 3];
        }
        for (int i = 0; i < str.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str[i].length(); j++) {
                sb.append((char)((str[i].charAt(j) - 97 + a[j]) % 26 + 97));
            }
            res[i] = sb.toString();
        }
        return res;
    }
}
