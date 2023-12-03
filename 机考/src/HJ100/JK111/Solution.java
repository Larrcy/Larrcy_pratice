package HJ100.JK111;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        //用数组来记录开始和结束时间
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        solution(m, n, arr);
    }


    private static void solution(int m, int n, int[][] arr) {
        //按照起始时间从小到大排序
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        //将结束时间存入栈
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{arr[0][1], 1});
        for (int i = 1; i < n; i++) {
            boolean flag = false;
            for (int[] p : deque) {
                if (p[0] <= arr[i][0] && p[1] < m) {
                    p[1]++;
                    p[0] = arr[i][1];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                deque.offer(new int[]{arr[i][1], 1});
            }
        }
        System.out.print(deque.size());
    }
}
