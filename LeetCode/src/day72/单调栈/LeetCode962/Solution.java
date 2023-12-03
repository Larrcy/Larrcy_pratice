package day72.单调栈.LeetCode962;

import java.util.Stack;

/**
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * <p>
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 */
public class Solution {

    public int maxWidthRamp(int[] A) {

        int n = A.length;
        int maxWidth = 0;
        //本题要找的是比nums[i]大的最右边的元素
        //首先正序遍历数组 A，将以 A[0] 开始的递减序列的元素下标依次存入栈中。
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<n;i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.push(i);
            }
        }
        //此时栈 stack：(4(0), 1(1), 0(6))：然后逆序遍历数组 A
        //若以栈顶元素为下标的元素值 A[stack.peek()] 小于等于当前遍历的元素 A[i]
        //即 A[stack.peek()] <= A[i]
        //此时就是一个满足条件的坡的宽度，
        //且这个宽度一定是栈顶这个坡底 i 能形成的最大宽度
        //将栈顶元素出栈并计算当前坡的宽度，保留最大值即可。
        for (int i=n-1;i>=0;i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                int pos = stack.pop();
                maxWidth = Math.max(maxWidth, i - pos);
            }
        }
        return maxWidth;
    }

}
