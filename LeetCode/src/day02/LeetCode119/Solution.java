package day02.LeetCode119;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int rowIndex = 10;
        System.out.println(getRow(rowIndex));
    }

    public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < rowIndex; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                //在第一位或最后一位时为1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    //在其他位置时为前一行对应的两数之和
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        //获取整个大集合中的指定小集合
        return ret.get(rowIndex-1);

    }
}