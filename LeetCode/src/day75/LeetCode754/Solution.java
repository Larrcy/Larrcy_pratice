package day75.LeetCode754;

/**
 * 数学推导 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
 *
 * 你可以做一些数量的移动 numMoves :
 *
 * 每次你可以选择向左或向右移动。
 * 第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
 * 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。
 */
public class Solution {
    //分类讨论
    //1.如果不回头地往终点走 n 步，并恰好能走到终点，那么答案就是 n。
    //如果无法恰好走到终点，则进行分类讨论
    //2.若越过终点且与终点相距偶数 若相距2则第一步反走 若相距4则第二步反走
    //3.若越过终点且与终点相距奇数
    //若多走一步相距变为偶数则转换为2
    //若越过终点且多走一步扔相距奇数
    //则再多走一步相距必为偶数
    public int reachNumber(int target) {
        target = Math.abs(target);
        int s = 0, n = 0;
        while (s < target || (s - target) % 2 == 1) // 没有到达（越过）终点，或者相距奇数
            s += ++n;
        return n;
    }

}
