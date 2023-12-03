package 基础算法.Sort.MergeSort;

import java.util.Arrays;

public class Solution {
    public static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        //开始合并数组
        int[] temp = new int[arr.length];
        int k = 0;
        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        //合并完后还有数组剩余则将剩下的添加到temp
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= end) temp[k++] = arr[j++];
        for (int m = start, n = 0; m <= end; m++, n++) {
            arr[m] = temp[n];

        }
    }


    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 8, 2, 1};
        int n = arr.length;

        System.out.println("原始数组：" + Arrays.toString(arr));

        mergeSort(arr, 0, n - 1);

        System.out.println("排序后数组：" + Arrays.toString(arr));
    }
}
