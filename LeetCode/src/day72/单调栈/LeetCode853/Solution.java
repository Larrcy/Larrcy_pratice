package day72.单调栈.LeetCode853;

import java.util.Arrays;
import java.util.Stack;

/**
 * 栈 在一条单行道上，有 n 辆车开往同一目的地。目的地是几英里以外的 target 。
 * <p>
 * 给定两个整数数组 position 和 speed ，长度都是 n ，其中 position[i] 是第 i 辆车的位置， speed[i] 是第 i 辆车的速度(单位是英里/小时)。
 * <p>
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车 以相同的速度 紧接着行驶。此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * <p>
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * <p>
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * <p>
 * 返回到达目的地的 车队数量 。
 */
public class Solution {
    static class Car {
        int pos;
        int v;

        public Car(int p, int v) {
            this.pos = p;
            this.v = v;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Car[] cars = new Car[n];

        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
       //从终点开始降序排列
        Arrays.sort(cars, (a, b) -> Integer.compare(a.pos,b.pos));
        Stack<Double> stack = new Stack<>();
        // 维护递增的stack，速度快，耗时少的 被贪心吞灭
        for (int i = 0; i < cars.length; i++) {
            double t = (target - cars[i].pos) * 1.0d / cars[i].v;
            if (!stack.isEmpty() && stack.peek() >= t) {
                // merge
            } else {
                stack.push(t);
            }
        }
        return stack.size();


    }
}
