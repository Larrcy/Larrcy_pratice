package day22.LeetCode120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        System.out.println(minimumTotal(triangle));


    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        //分3种情况讨论
        // dp[i][0] 这种情况只能由他上面的元素推导过来
        // dp[i][i]只能由其左上方的元素推导过来 其上方元素没有意义
        // 在1~i-1的情况 可以由其上方和其左上方的元素推导过来
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);

            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        //最后我们遍历最后一层的dp数组 求出该层的最小值即为答案
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            if (res > dp[triangle.size() - 1][i])
                res = dp[triangle.size() - 1][i];
        }
        return res;

    }
}
