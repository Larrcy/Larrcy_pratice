package day36.Need.LeetCode978;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int len = arr.length;
        int up = 1;
        int down = 1;
        int ans = 1;
        //交替统计上升下降的序列
        //若出现不连续的情况则将他们重置为1
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) {
                up = down + 1;
                down = 1;
            } else if (arr[i] < arr[i - 1]) {
                down = up + 1;
                up = 1;
            } else {
                up = 1;
                down = 1;
            }
            ans = Math.max(ans, Math.max(up, down));
        }
        return ans;

    }
}
