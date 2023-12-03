package HJ100.JK098;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] members = new int[10];
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            members[i] = sc.nextInt();
            sum += members[i];
        }
        int count = 5;
        int res = Integer.MAX_VALUE;
        res = backtrack(members, 0, count, sum, res);
        System.out.println(res);

    }

    public static int backtrack(int[] members, int index, int count, int sum, int res) {
        if (count == 0) {
            return Math.abs(sum);
        }
        for (int i = index + 1; i < 10; i++) {
            res = Math.min(backtrack(members, i, count - 1, sum - members[i] * 2, res), res);
        }
        return res;
    }


}
