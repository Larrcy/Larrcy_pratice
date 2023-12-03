package day25.LeetCode31;

public class Solution {
    //下一个排列
    //如1 2 7 4 3 1
    //1.我们首先倒序遍历数组 找出第一组前一个数比后一个数小的两个数即2 7
    //2.2所在的位置就是我们要找的比2稍大的数的位置
    //3.我们再从7 4 3 1中找出比2大的最小数 找到后与2所在位置进行交换(若找不到则直接对数组升序排列)
    //4.交换后得到1 3 7 4 2 1
    //5.我们再对3之后的元素进行升序排列即可得到最终结果 1 3 1 2 4 7
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2; //i = len - 2 是为了防止下面nums[i + 1]越界!

        //1. 倒序遍历, 找到第一个数, 这个数比后面的数小;
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) break;
            i--;
        }

        //2. 继续倒序遍历, 找到一个上面的数大的数
        if (i >= 0) {
            int j = len - 1;
            while (j >= 0) {
                //从后向前遍历到的第一个大于num[i]的元素一定是符合要求的
                //若前面有比num[j]更小的符合要求的数则在1中处理
                if (nums[j] > nums[i]) break;
                j--;
            }
            //3. 交换i和j
            swap(nums, i, j); //交换i和j的位置
        }

        //4. 将 i后面的数升序排列, 只需要对撞双指针交换即可(因为i后面的数时降序的)
        reverse(nums, i + 1, len - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
//排序
    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }

    }
}
