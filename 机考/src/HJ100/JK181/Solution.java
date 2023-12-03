package HJ100.JK181;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(func(s));
    }

    public static String func(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        String temp="";
        for (int i = 0; i < split.length; i++) {
            if (split[i].charAt(split[i].length() - 1) == '.' ||
                    split[i].charAt(split[i].length() - 1) == '?' ||
                    split[i].charAt(split[i].length() - 1) == ',') {
              temp = split[i].substring(split[i].length() - 1);
                split[i] = split[i].substring(0, split[i].length() - 1);
            }
            for (int j =  split[i].length()-1; j >=0; j--) {
                sb.append(split[i].charAt(j));
            }
            sb.append(temp).append(" ");
            temp="";
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
