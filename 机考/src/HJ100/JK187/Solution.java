package HJ100.JK187;

import java.util.Scanner;
//数组中心位置元素
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        System.out.println(func(split));
    }

    public static int func(String[] split) {
        int n = split.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = 1;
        suf[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = Integer.parseInt(split[i - 1]) * pre[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Integer.parseInt(split[i + 1]) * suf[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (pre[i] == suf[i]) {
                return i;
            }
        }
        return -1;
    }
}
