package day28.LeetCode874;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int result = 0;
        int x = 0, y = 0, direction = 0;
        //用数组来存储朝不同方向前进时 x,y的坐标变化
        //朝东西时 x发生变化 朝南北时y发生变化
        int[] directX = new int[]{0, 1, 0, -1};
        int[] directY = new int[]{1, 0, -1, 0};

        // 用 set 存储障碍物的坐标
        Set<String> obstaclesSet = new HashSet<String>();
        for (int i = 0; i < obstacles.length; i++) {
            obstaclesSet.add(obstacles[i][0] + "," + obstacles[i][1]);
        }
        //关于方向：
        //绕原点 (0, 0) 按顺时针方向看，设：direction 北=0 东=1 南=2 西=3
        //当前方向：朝北(0)  朝东(1)  朝南(2)  朝西(3)
        //左转后：  朝西(3)  朝北(0)  朝东(1)  朝南(2)
        //右转后：  朝东(1)  朝南(2)  朝西(3)  朝北(0)
        //可以得出
        //左转后 direction + 3 -> (direction + 3) % 4 （左转一次，相当于是右转了三次）
        //右转后 direction + 1 -> (direction + 1) % 4
        for (int com : commands) {
            //对左转右转进行判断
            if (com == -2) {
                // turn left
                direction = (direction + 3) % 4;
            } else if (com == -1) {
                // turn right
                direction = (direction + 1) % 4;
            } else {
                for (int i = 1; i <= com; i++) {
                    // 下一步的坐标
                    int newX = x + directX[direction];
                    int newY = y + directY[direction];
                    // 遇到障碍物，停止前进
                    if (obstaclesSet.contains(newX + "," + newY)) {
                        break;
                    }
                    // 前进
                    x = newX;
                    y = newY;
                    // 最大欧式距离的平方
                    result = Math.max(result, x * x + y * y);
                }
            }
        }
        return result;
    }

}
