package day01.LeetCode70;

public class Solution {
    public static void main(String[] args) {

    }

    //考虑最后一步迈了几个台阶则为f(x)=f(x−1)+f(x−2)
    //即第三次的爬楼梯方法数为前两次之和
    //所以利用动态规划
    public static int climbStairs(int n) {
        //若x=0
        //则只有一种方法 故定0级台阶的方法数为1
        //x=1=> 0+1
        //x=2=>1+1
        //x=3=>2+1
        //因此将整个斐波那契数列看成一个数组
        //从第三个数开始每个数为前两个数之和
        //从第0阶开始
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            //进行循环时
            //将p q 向后移动一位
            p = q;
            q = r;
            //1阶时 为-1阶（0种）和0阶（1种）之和
            r = p + q;
        }
        return r;
    }
}
