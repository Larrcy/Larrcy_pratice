package LeetCode75_1.LeetCode334;

public class Solution {
    //贪心算法
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        //遍历整个数组寻找满足条件的第三个数
        for (int i = 1; i < n; i++) {
            //找第三个数
            int num = nums[i];
            //找到比第二个大的数则满足条件
            if (num > second) {
                return true;
            }
            //若第三个数比第二个数小但是比第一个数大
            //则把第三个数作为第二个数
            else if (num > first) {
                second = num;
            }
            //若第三个数比第一个数还小
            //则把第三个数作为第一个数
            else {
                first = num;
            }
        }
        return false;
    }
}
