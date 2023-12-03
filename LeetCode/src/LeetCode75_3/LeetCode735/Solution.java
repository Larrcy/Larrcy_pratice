package LeetCode75_3.LeetCode735;

import java.util.*;

public class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int aster : asteroids) {
            boolean alive = true;
            //遍历且判断行星是否存活
            //若栈顶的行星大于0且遍历到的行星小于0则会碰撞
            while (alive && aster < 0 && !stack.isEmpty() && stack.peek() > 0) {
                //等于0时，遍历到的行星爆炸
                alive = stack.peek() < -aster; // aster 是否存在
                // 栈顶行星爆炸，将栈顶元素出栈
                if (stack.peek() <= -aster) {
                    stack.pop();
                }
            }
            //将存活的行星放入栈中
            if (alive) {
                stack.push(aster);
            }
        }

        int size = stack.size();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
