package day72.单调栈.LeetCode907;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 单调栈+dp
 * 给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * <p>
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 */
public class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long ans = 0;
        int mod = 1000000007;
        //设dp[i]为以arr[i]结尾的子数组的最小值之和
        //例如 arr={3，1，2，4}
        //当nums[i]=4时
        //我们可以得出dp[i]= dp[i-1]+min(4)+min(2,4)+min(1,2,4)+min(3,1,2,4)
        //更详细的 dp[i]= dp[i-1]+所有以i为结尾的子数组的最小值
        //我们设以arr[i]为结尾且以arr[i]为最小值的最长子数组长度为k
        //举个例子 3 5 6 4
        //此时以4为结尾且4为最小值的最长子数组为5 6 4 长度为3
        //5左边一定有比4更小的元素，5右边的元素最小值一定为arr[i]
        //所以我们只需要在5左边的子数组中取一下最小值 这个最小值即为以4结尾的子数组的最小值
        //我们设在i-k+1左边的元素其以arr[i]结尾子数组的最小值为min(arr[i-k],arr[i-k-1]...)
        //因此我们可以写出递推公式dp[i]=dp[i-k]+k*arr[i]
        //子数组的最小值我们可以利用一个单调栈来进行维护
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            //栈内维护子数组的最小值
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            int k = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            dp[i] = k * arr[i] + (stack.isEmpty() ? 0 : dp[i - k]);
            ans = (ans + dp[i]) % mod;
            stack.push(i);
        }
        return (int) ans;
    }

}
