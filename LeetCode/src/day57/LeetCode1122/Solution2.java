package day57.LeetCode1122;

import java.util.*;

public class Solution2 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // map 存储arr2中元素以及其对应的下标位置
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Integer[] temp = new Integer[arr1.length];
        //将int[] arr1 转成 Integer[] temp,
        for (int i = 0; i < arr1.length; i++) {
            temp[i] = arr1[i];
        }
        //按自定义方式排序
        Arrays.sort(temp, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                //若a和b都在arr2中，按map中存储的下标位置从小到大排序
                if (map.containsKey(a) && map.containsKey(b)) {
                    return map.get(a) - map.get(b);
                } else if (map.containsKey(a)) { //若只有a出现在arr2中，a排在前面
                    return -1;
                } else if (map.containsKey(b)) { //若只有b出现在arr2中，b排在前面
                    return 1;
                } else { //若a和b都不在arr2中，按其值从小到大排列
                    return a - b;
                }
            }
        });
        //将Integer类型转回基本数据类型int
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = temp[i];
        }
        return arr1;
    }


}
