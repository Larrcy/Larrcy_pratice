package day06.LeetCode338;

public class Solution2 {
    //方法二 动态规划
    public static void main(String[] args) {


    }
    public int[] countBits(int n) {
        //新建的数组每一个位置的数都为0
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //i & (i - 1)表示将二进制数的最低位的1变成0如 110->100
            //判断一个数是否为2的幂可以用位运算 i & (i - 1)==0来判断
            //i=1 nums[1]=nums[0]+1     =1
            //i=2 nums[2]=nums[00]+1    =1
            //i=3 nums[3]=nums[010]+1   =2
            //i=4 nums[4]=nums[000]+1   =1
            //首位为0不需要判断
            //所以得出递推式   nums[i] = nums[i & (i - 1)] + 1
            nums[i] = nums[i & (i - 1)] + 1;
        }
        return nums;
    }

}
