package LeetCode75_2.LeetCode11;

import java.util.*;

public class Solution {
    public int maxArea(int[] height) {
        //将指针指向数组左右两端
        int l = 0, r = height.length - 1;
        int ans = 0;
        //左右指针向中间移动
        while (l < r) {
            //计算容积
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            //若左指针比右指针小 则左指针向右移动
            //否则右指针向左移动
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }

}
