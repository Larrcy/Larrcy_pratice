package day25.LeetCode2545;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][]score ={{10,6,9,1},{7,5,11,2},{4,8,3,15}};
        int k =2;
        System.out.println(sortTheStudents(score, k));
    }
    public static int[][] sortTheStudents(int[][] score, int k) {
    int[][]res =new int[score.length][score[0].length];
        LinkedHashMap<Integer,Integer>map =new LinkedHashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(score[i][k],i);
        }
        List<Integer>list =new ArrayList<>();
        for (Integer value : map.values()) {
            list.add(value);
        }
        for (int i = 0; i < res.length; i++) {
            res[i]=score[list.get(list.size()-i-1)];
        }
        return res;
    }
}
