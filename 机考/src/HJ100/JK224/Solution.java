package HJ100.JK224;

import java.util.Scanner;
//光伏场地建设规划
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int len = sc.nextInt();
        int a = sc.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        for (int i = 0; i <= m - len; i++) {
            for (int j = 0; j <= n - len; j++) {
                for (int k = i; k < i + len; k++) {
                    for (int l = j; l < j + len; l++) {
                        if (nums[k][l] >= a) {
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
