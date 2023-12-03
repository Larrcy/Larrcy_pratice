package day55.LeetCode1253;

import java.util.*;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int count = 0;
        for (int i = 0; i < colsum.length; i++) {
            count += colsum[i];
        }
        if (count != upper + lower) return res;
        int[] res1 = new int[colsum.length];
        int[] res2 = new int[colsum.length];
        Set<Integer>set =new HashSet<>();
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2 && lower > 0) {
                set.add(i);
                res1[i] = 1;
                lower--;
            }
        }
        for (int i = 0; i < colsum.length; i++) {

            if (!set.contains(i)&&colsum[i] == 1 && lower > 0) {
                res1[i] = 1;
                lower--;
            }
        }

        for (int i = 0; i < res2.length; i++) {
            res2[i] = colsum[i] - res1[i];
        }
        for (int i = 0; i < 2; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < res1.length; i++) {
            if(res2[i]==2)return res;
            res.get(0).add(res2[i]);
        }
        for (int i = 0; i < res1.length; i++) {
            if(res1[i]==2)return res;
            res.get(1).add(res1[i]);
        }
        return res;
    }
}
