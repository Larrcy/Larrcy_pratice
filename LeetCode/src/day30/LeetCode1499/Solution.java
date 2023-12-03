package day30.LeetCode1499;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        // 初始化结果变量为最小整数值，因为结果至少要比最小整数大
        int ans = Integer.MIN_VALUE;
        // 使用双端队列来存储点对 [xi, yi-xi] 中的 [xi, yi]，其中 yi-xi 是每个点对的增量
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 遍历输入的点对数组 points
        for (int[]  p : points) {
            int x = p[0], y = p[1];

            // 队首超出范围：如果队首元素的 x 坐标小于当前点的 x 坐标减去 k，
            // 说明队首元素已经不在滑动窗口范围内，因此需要从队首移除
            while (!q.isEmpty() && q.peekFirst()[0] < x - k)
                q.pollFirst(); // 弹出队首元素

            // 非空队列：如果队列不为空，说明存在在滑动窗口范围内的点对
            if (!q.isEmpty())
                // 更新结果：将当前点和队首元素的 y 坐标差值加上当前点的 x 坐标
                // 与当前结果 ans 进行比较，取最大值作为新的结果
                ans = Math.max(ans, x + y + q.peekFirst()[1]);

            // 队尾不如新来的强：如果队尾元素的 y 坐标减去 x 坐标小于等于当前点的 y 坐标减去 x 坐标，
            // 说明队尾元素不如当前点对 (xi, yi-xi) 强，因此需要从队尾移除
            while (!q.isEmpty() && q.peekLast()[1] <= y - x)
                q.pollLast(); // 弹出队尾元素

            // 将当前点对 (xi, yi-xi) 添加到队尾，准备下一轮的比较
            q.addLast(new int[]{x, y - x});
        }

        // 返回最终的结果
        return ans;
    }

}
