package Char11.S5.LeetCode84;

import java.util.Stack;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        int[] newHeights = new int[heights.length + 2];
        //将数组头尾扩充上0
        //防止出现递增或递减时无法进行求值
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }
        heights = newHeights;
        st.push(0);
        int res = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] >= heights[st.peek()]) {
                st.push(i);
            } else {
                while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                    int mid = st.peek();
                    st.pop();
                    int h = heights[mid];
                    int w = i -st.peek() - 1;
                    res= Math.max(res, w * h);
                }
                st.push(i);
            }
        }
        return res;
    }
}
