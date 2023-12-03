package HJ100.JK091;

import java.util.Scanner;

public class Solution {
    //单词反转2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(reverse(s, start, end));
    }

    public static String reverse(String s, int start, int end) {
        if (start < 0) start = 0;
        String[] split = s.split(" ");
        if (end > split.length-1) end = split.length - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = end; i >= start; i--) {
            sb.append(split[i]).append(" ");
        }
        StringBuilder m = new StringBuilder();
        StringBuilder n = new StringBuilder();
        for (int i = 0; i < start; i++) {
            m.append(split[i]).append(" ");
        }
        for (int i = end + 1; i < split.length ;i++) {
            n.append(split[i]).append(" ");
        }
        String res = m.append(sb).append(n).toString();
        return res.substring(0,res.length()-1);
    }
}
