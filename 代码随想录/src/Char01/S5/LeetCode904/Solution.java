package Char01.S5.LeetCode904;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[]fruits ={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));

    }

    //找至多包含两种元素的最长子串，返回其长度
        public static int totalFruit(int[] fruits) {
            int n = fruits.length;
            //用map存储数字出现的次数
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

            int left = 0, ans = 0;
            for (int right = 0; right < n; ++right) {
                cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
                //当map的长度大于2时 左指针移动
                while (cnt.size() > 2) {
                    //对左指针所指的元素减少一次
                    cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                    //若为0则左指针移动
                    if (cnt.get(fruits[left]) == 0) {
                        cnt.remove(fruits[left]);
                    }
                    ++left;
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
}
