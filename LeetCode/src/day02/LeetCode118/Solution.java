package day02.LeetCode118;

import java.util.ArrayList;
import java.util.List;

//杨辉三角
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
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
        return ret;
    }
}
