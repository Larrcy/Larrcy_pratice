package HJ100.JK130;

import java.util.Scanner;
//IP地址转整数
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("#");
       if( func(split)==-1){
           System.out.println("invalid IP");
       }else
           System.out.println(func(split));
    }

    public static long func(String[] split) {
        long count = 0;
        if (split.length != 4) return -1;
        for (int i = 0; i < split.length; i++) {
            long n = Integer.parseInt(split[i]);
            if (i == 0 && Integer.parseInt(split[0]) < 1 || Integer.parseInt(split[0]) > 128) {
                return -1;
            } else if (Integer.parseInt(split[i]) < 0 || Integer.parseInt(split[i]) > 255) {
                return -1;
            } else {
                count += n << (8 * (3 - i));
            }
        }
        return count;
    }
}
