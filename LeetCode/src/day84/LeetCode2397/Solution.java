package day84.LeetCode2397;

import java.util.*;

/**
 * 给你一个下标从 0 开始、大小为 m x n 的二进制矩阵 matrix ；另给你一个整数 numSelect，表示你必须从 matrix 中选择的 不同 列的数量。
 * <p>
 * 如果一行中所有的 1 都被你选中的列所覆盖，则认为这一行被 覆盖 了。
 * <p>
 * 形式上，假设 s = {c1, c2, ...., cnumSelect} 是你选择的列的集合。对于矩阵中的某一行 row ，如果满足下述条件，则认为这一行被集合 s 覆盖：
 * <p>
 * 对于满足 matrix[row][col] == 1 的每个单元格 matrix[row][col]（0 <= col <= n - 1），col 均存在于 s 中，或者
 * row 中 不存在 值为 1 的单元格。
 * 你需要从矩阵中选出 numSelect 个列，使集合覆盖的行数最大化。
 * <p>
 * 返回一个整数，表示可以由 numSelect 列构成的集合 覆盖 的 最大行数
 */
public class Solution {
    //子集型回溯
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public int maximumRows(int[][] mat, int cols) {
        int n = mat[0].length;
        dfs(n, cols, 0);
        int res = 0;
        for (List<Integer> path : list) {
            res = Math.max(res, getmax(mat, path));
        }
        return res;
    }

    /**
     * 递归回溯获取全部个数为cols的组合
     */
    private void dfs(int n, int cols, int StartIndex) {
        if (path.size() == cols) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = StartIndex; i < n; i++) {
            path.add(i);
            dfs(n, cols, i + 1);
            path.remove(path.size() - 1);
        }
    }

    //获取能够覆盖的行数
    private int getmax(int[][] mat, List<Integer> cols) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            boolean flag = true;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && !cols.contains(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) res++;
        }
        return res;
    }


}
