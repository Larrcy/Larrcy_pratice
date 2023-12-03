package HJ100.JK204;

import java.util.Scanner;
//新员工座位安排系统
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(func(s));

    }

    public static int func(String s) {
        String[] split = s.split("2");
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            String[] man = split[i].split("0");
            for (int j = 1; j < man.length; j++) {
                max = Math.max(man[j].length() + man[j - 1].length(), max);
            }
        }
        return max;
    }
}
