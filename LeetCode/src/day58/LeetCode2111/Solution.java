package day58.LeetCode2111;

import java.util.*;

public class Solution {
    public int kIncreasing(int[] arr, int k) {
        int result = 0;
        for (int i = 0; i < k; i++) {
            result += findK(arr, i, k);
        }
        return result;
    }

    public int findK(int[] arr, int start, int k) {
        int num = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < arr.length; i += k) {
            num++;//计算一共有多少数
            int index = binarySearch(list, arr[i]);
            if (index == list.size()) {
                list.add(arr[i]);
            } else {
                list.set(index, arr[i]);
            }
        }
        return num - list.size();//该子序列的元素个数减去
    }

    public int binarySearch(List<Integer> list, int target) {
        if (list.size() == 0) return 0;
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}
