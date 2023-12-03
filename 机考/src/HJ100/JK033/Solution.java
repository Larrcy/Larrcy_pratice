package HJ100.JK033;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int R = sc.nextInt();
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();

        }
        //输出最近的找到第一个直接跳出即可
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr1[i] <= arr2[j] && Math.abs(arr1[i] - arr2[j]) <= R) {
                    System.out.println(arr1[i] + " " + arr2[j]);
                    break;
                }
            }
        }
    }
}
