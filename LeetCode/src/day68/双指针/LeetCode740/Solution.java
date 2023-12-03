package day68.双指针.LeetCode740;

/**
 * 给你一个字符串 s ，下标从 0 开始 ，且长度为偶数 n 。字符串 恰好 由 n / 2 个开括号 '[' 和 n / 2 个闭括号 ']' 组成。
 * <p>
 * 只有能满足下述所有条件的字符串才能称为 平衡字符串 ：
 * <p>
 * 字符串是一个空字符串，或者
 * 字符串可以记作 AB ，其中 A 和 B 都是 平衡字符串 ，或者
 * 字符串可以写成 [C] ，其中 C 是一个 平衡字符串 。
 * 你可以交换 任意 两个下标所对应的括号 任意 次数。
 * <p>
 * 返回使 s 变成 平衡字符串 所需要的 最小 交换次数。
 */
public class Solution {
    //如果你不删除当前位置的数字，那么你得到就是前一个数字的位置的最优结果。
    //如果你觉得当前的位置数字i需要被删，那么你就会得到i - 2位置的那个最优结果加上当前位置的数字乘以个数。
    //以上两个结果，你每次取最大的，记录下来，然后答案就是最后那个数字了。
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        //用数组中元素的最大值作为dp数组的长度
        int max = nums[0];
        for (int i = 0; i < len; ++i) {
            max = Math.max(max, nums[i]);
        }
        //cnt数组用来统计每个数出现的次数
        int[] cnt = new int[max+1];
        for (int item : nums) {
            cnt[item] ++;
        }
        int[] dp = new int[max+1];
       //只有一个数字1时 dp[1]为1出现的次数
        dp[1] = cnt[1];

        for (int i = 2; i <= max; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * cnt[i]);
        }
        return dp[max];
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}




