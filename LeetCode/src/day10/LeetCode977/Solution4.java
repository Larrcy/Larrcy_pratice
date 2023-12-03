package day10.LeetCode977;

public class Solution4 {
    //选择排序
    //先假定第i个元素为最小值
    //然后遍历i之后的元素
    //若有比假定元素更小的数 则将值记录下来 同时记录其索引
    //则将假定元素的值与所遍历到的最小元素的值进行互换
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        SelectSort(nums);
        return nums;

    }

    public void SelectSort(int[] nums) {
        //最后一位不用判断 故循环到 nums.length-1
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    //将后面遍历到的最小值赋值给min
                    min = nums[j];
                    //同时记录最小值的索引
                    minIndex = j;
                }
            }
            //若当前最小值的索引不是我们所假设的索引
            if (minIndex != i) {
                //则将假设的索引元素与我们所找到的最小元素进行互换
                nums[minIndex] = nums[i];
                nums[i] = min;
            }
        }
    }
}
