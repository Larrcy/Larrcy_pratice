package day29.LeetCode2012;

public class Solution {
    /*
     初始化：维护两个变量 max、min ，分别保存正序遍历到的数左边的最大值和倒序遍历到的数右边的最小值，并使用一个boolean数组保存当前数是否可以+2的状态
     正序遍历：判断当前数是否满足大于左边所有数（大于左边最大值）的条件
     若满足就先记录为true，并更新左边的最大值 max，以便下一个数的判断使用
     倒序遍历：判断当前数是否满足小于右边所有数（小于右边最小值）的条件
     若满足就表示当前数满足+2的条件，更新右边的最小值；
     若不满足，需将数组中当前数的状态记为false，防止只满足左边条件的情况
     */
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;

        //保存左边最大
        int max = nums[0];
        //保存右边最小
        int min = nums[n - 1];

        //初始化状态数组，保存当前数是否满足条件
        boolean[] sat = new boolean[n];

        //先从左开始遍历
        for (int i = 1; i <= n - 2; ++i) {
            //中间数如果大于左边最大，说明这个数左半边都满足条件
            if (max < nums[i]) {
                sat[i] = true;
                max = nums[i];
            }
        }

        //再从右开始遍历
        for (int i = n - 2; i >= 1; --i) {
            //中间数如果小于右边最小，说明这个数右半边都满足条件
            if (nums[i] < min) {
                min = nums[i];
            } else { //不满足需要重置为false，防止只满足左边的情况
                sat[i] = false;
            }
        }

        int res = 0;
        for (int i = 1; i <= n - 2; ++i) {
            if (sat[i]) {
                res += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                res += 1;
            }
        }

        return res;
    }

}
