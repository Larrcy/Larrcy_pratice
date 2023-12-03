package day37.LeetCode1385;

import java.util.Arrays;

public class Solution2 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        Arrays.sort(arr2);
        for (int elem : arr1) {
            if(maxDis(arr2, d, elem)) res++;
        }
        return res;
    }

    // 通过二分查找，找到大于等于target的最小值i1，以及小于target的最小值i2
    // 检查 |target-i1| 和 |target-i2| 是否都大于d，是的话，表明整个arr的元素都符号距离要求，返回true
    public boolean maxDis(int[] arr, int d, int target){
        int l = 0, r = arr.length - 1;
        while(l <= r){
            int c = (l + r) >> 1;
            if(arr[c] < target) l = c + 1;
            else r = c - 1;
        }
        if(l != arr.length && Math.abs(arr[l] - target) <= d) return false;
        if(r != -1 && Math.abs(arr[r] - target) <= d) return false;
        return true;
    }



}
