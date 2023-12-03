package 基础算法.SlideWindow;

import java.util.HashMap;

public class Solution {
    //前缀和滑动窗口模板
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int preSum = 0;
        for (int num : nums) {
            //此处计算前缀和
            /*
            if (num % 2 != 0) {//判断是否为奇数
                preSum++;
            }*/
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            if (map.containsKey(preSum)) {
                map.put(preSum, map.get(preSum) + 1);
            } else {
                map.put(preSum, 1);
            }
        }
        return count;
    }
}
