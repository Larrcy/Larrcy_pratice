package HJ100.JK010;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] array = fillArray(n, m);
        printArray(array);
    }

    public static int[][] fillArray(int n, int m) {
        int[][] array = new int[n][m];
        int num = 1;

        for (int i = 0; i < n + m - 1; i++) {
            int x = i < n ? i : n - 1;
            int y = i - x;

            while (x >= 0 && y < m) {
                array[x][y] = num++;
                x--;
                y++;
            }
        }

        return array;
    }

    public static void printArray(int[][] array) {
        for (int j = 0; j < array[0].length; j++) {
        for (int i = 0; i < array.length; i++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
