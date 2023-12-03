package day13.LeetCode454;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count =0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                map.put(nums1[i] + nums2[j], map.getOrDefault(nums1[i] + nums2[j], 0) + 1);
            }
        }
        for (Integer value : map.values()) {

        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                //设置目标值 若map中存在
                //则返回其出现的次数
                int target =-nums3[i]-nums4[j];
            if(map.containsKey(target)){
                count=count+map.get(target);
            }
            }
        }
        return count;

    }
}
