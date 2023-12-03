package Char09.S14.LeetCode406;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //将身高从大到小进行排序 身高相同k值小的在前面
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            return b[0]-a[0];
        });
        LinkedList<int[]>que =new LinkedList<>();
        for (int[] p : people) {
            //p[1]为k值插入位置
            que.add(p[1],p);
        }
        return que.toArray(new int[people.length][]);
    }
}
