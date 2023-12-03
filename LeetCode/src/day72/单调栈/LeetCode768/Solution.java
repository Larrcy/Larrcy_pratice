package day72.单调栈.LeetCode768;

import java.util.Stack;

/**
 * 单调栈 给你一个整数数组 arr 。
 * <p>
 * 将 arr 分割成若干 块 ，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * <p>
 * 返回能将数组分成的最多块数？
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            //每个分块都有一个最大值
            //这些最大值是单调递增的
            if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
                stack.push(i);
            } else {
                //只存一个最大值
                int maxIdx = stack.pop();
                //若栈顶元素大于arr[i]说明可以合并到一个块
                //若不大于则只能和当前栈顶的最大值合并成一个块最大值仍为max
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                stack.push(maxIdx);
            }

        }
        return stack.size();
    }
}
