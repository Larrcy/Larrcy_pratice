package day39.LeetCode2661;
import java.util.*;
public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int len = arr.length, m = mat.length, n = mat[0].length;
        Map<Integer, List<Integer>> myMap = new HashMap<>();
        //用map来记录mat中每个数的位置
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                myMap.put(mat[i][j], Arrays.asList(i, j));
            }
        }
        //row col记录每行每列的涂色个数
        int[] row = new int[m];
        int[] col = new int[n];

        for(int i = 0; i < len; i++){
            int num = arr[i];
            List<Integer> list = myMap.get(num);
            int x = list.get(0), y = list.get(1);
            ++row[x];
            ++col[y];

            if(row[x] == n || col[y] == m)
                return i;
        }

        return 0;
    }
}
