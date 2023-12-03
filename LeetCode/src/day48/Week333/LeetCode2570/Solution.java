package day48.Week333.LeetCode2570;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i][0], nums1[i][1]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (!map1.containsKey(nums2[i][0])) {
                map1.put(nums2[i][0], nums2[i][1]);
            } else {
                map1.put(nums2[i][0], map1.get(nums2[i][0]) + nums2[i][1]);
            }
        }
        int[][] res = new int[map1.size()][2];
        int count = 0;
        for (Integer key : map1.keySet()) {
            res[count][0] = key;
            res[count][1] = map1.get(key);
            count++;
        }

        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        return res;


    }
}
