package day58.LeetCode1222;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[][] queens = {{0, 1}, {1, 0}};
        int[] king = {0, 0};
        System.out.println(queensAttacktheKing(queens, king));
    }


    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> list = new ArrayList<>(Arrays.asList(queens));
        for (int i = king[0] - 1; i >= 0; i--) {
            boolean flag = false;
            for (int[] ints : list) {
                if (ints[0] == i && ints[1] == king[1]) {
                    res.add(Arrays.asList(i, king[1]));
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        for (int i = king[0] + 1; i <= 7; i++) {
            boolean flag = false;
            for (int[] ints : list) {
                if (ints[0] == i && ints[1] == king[1]) {
                    res.add(Arrays.asList(i, king[1]));
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        for (int i = king[1] + 1; i <= 7; i++) {
            boolean flag = false;
            for (int[] ints : list) {
                if (ints[0] == king[0] && ints[1] == i) {
                    res.add(Arrays.asList(king[0], i));
                    flag = true;
                    break;
                }
            }
            if (flag) break;

        }
        for (int i = king[1] - 1; i >= 0; i--) {
            boolean flag = false;
            for (int[] ints : list) {
                if (ints[0] == king[0] && ints[1] == i) {
                    res.add(Arrays.asList(king[0], i));
                    flag = true;
                    break;
                }
            }
            if (flag) break;

        }
        for (int i = king[1] - 1, j = king[0] - 1; i >= 0 && j >= 0; i--, j--) {
            boolean flag = false;
            for (int[] ints : list) {
                if (ints[0] == j && ints[1] == i) {
                    res.add(Arrays.asList(j, i));
                    flag = true;
                    break;
                }
            }
            if (flag) break;

        }
        for (int i = king[1] + 1, j = king[0] + 1; i < 8 && j < 8; i++, j++) {
            boolean flag = false;
            for (int[] ints : list) {
                if (ints[0] == j && ints[1] == i) {
                    res.add(Arrays.asList(j, i));
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        for (int i = king[1] + 1, j = king[0] - 1; i < 8 && j >= 0; i++, j--) {
            boolean flag = false;
            for (int[] ints : list) {
                if (ints[0] == j && ints[1] == i) {
                    res.add(Arrays.asList(j, i));
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        for (int i = king[1] - 1, j = king[0] + 1; i >= 0 && j < 8; i--, j++) {
            boolean flag = false;
            for (int[] ints : list) {
                if (ints[0] == j && ints[1] == i) {
                    res.add(Arrays.asList(j, i));
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        return res;
    }
}
