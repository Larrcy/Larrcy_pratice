package HJ100.JK195;

import java.util.*;
//最小施肥机能
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if (n < m) System.out.println(-1);
        else {
            int[] fields = new int[m];
            for (int i = 0; i < m; i++) {
                fields[i] = sc.nextInt();
            }
            Arrays.sort(fields);
            System.out.println(solution(m, n, fields));
        }
    }

    private static int solution(int m, int n, int[] fields) {
        for (int k = fields[0]; k < fields[fields.length - 1]; k++) {
            int days = 0;
            for (int j : fields) {
                int field = j;
                if (field <= k) {
                    days++;
                } else {
                    while (field > 0) {
                        days++;
                        field -= k;
                    }
                }
                if (days > n) {
                    break;
                }
            }
            if (days == n) {
                return k;
            }
        }
        return -1;
    }
}
