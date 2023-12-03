package 基础算法.Sort;

import java.util.Arrays;

public class QuickSort {
    static int count = 0;

    // 快速排序主函数，接受待排序数组和数组长度作为参数
    public static int quickSort(int[] arr, int start, int end) {

        if (start >= end) return count;
        // 划分数组，并得到划分点的位置
        int x = arr[start];
        int i = start - 1;
        int j = end + 1;
        while (i < j) {
            do i++; while (arr[i] < x);
            do j--; while (arr[j] > x);
            if (i < j) {
                swap(arr, i, j);
                count++;
            }

        }

        // 对划分点左边的子数组进行快速排序
        quickSort(arr, start, j);

        // 对划分点右边的子数组进行快速排序
        quickSort(arr, j + 1, end);
        return count;
    }


    // 交换数组中两个位置的元素
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4};
        int n = arr.length;

        System.out.println("原始数组：" + Arrays.toString(arr));

        System.out.println(quickSort(arr, 0, n - 1));

        System.out.println("排序后数组：" + Arrays.toString(arr));
    }
}
