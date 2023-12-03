package 基础算法.heap;


public class Solution {
    public void heapInsert(int[] arr, int index) {
        //若向堆中加入的元素小于自己的父节点
        //则将其与自己的父节点进行交换 直至自己比父节点小为止
        //父节点的位置为(index - 1) / 2
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //从堆中取出最大值后 我们首先将堆顶元素与堆中最后一个元素进行交换
    //然后缩小堆将最后一个元素除外此时我们能够获取最大值
    //然后对新的堆结构进行重新调整
    public void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            //判断是否有右孩子且右孩子是否比左孩子大 若大则与较大值进行交换
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            //然后再与自己比较是否比自己大
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) break;
            //交换值
            swap(arr, largest, index);
            //index移动到较大孩子的位置
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
