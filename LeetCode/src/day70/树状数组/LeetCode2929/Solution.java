package day70.树状数组.LeetCode2929;

/**
 * 给你两个正整数 n 和 limit 。
 *
 * 请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。
 */
public class Solution {
    //容斥原理
    //合法方案数(<=limit)=不考虑limit的所有方案数-不合法的方案数(至少有一个>limit)
    //不考虑limit的方案数
    //相当于将n个小球放入3个有区分的盒子中 允许空盒的方案数
    //因此我们总共有n+2个位置(2个位置放隔板)选2个位置放隔板
    //因此共c(n+2,2)种方案
    //根据容斥原理求不合法的总方案数为甲+乙+丙-甲乙-甲丙-乙丙+甲乙丙
    //其中
    //甲 >limit 乙>limit 丙>limit
    //甲乙 >limit 乙丙>limit  甲丙>limit
    //甲乙丙>limit
    //由于甲乙丙三者大小一样故可以合并
    //3*甲-3*甲乙+甲乙丙
    //以甲 >limit为例
    //若甲 >limit则提前向甲中放入limit+1个小球
    //剩下的小球再对甲乙丙进行合法分配
    //即c(n+2-(limit+1),2)
    //因此合法方案数为
    //c(n+2,2)-3*(c(n+2-(limit+1),2)-c(n+2-2*(limit+1),2))+c(n+2-3*(limit+1),2)
    public long distributeCandies(int n, int limit) {
        return c(n+2)-3*(c(n+2-(limit+1))-c(n+2-2*(limit+1)))-c(n+2-3*(limit+1));    }
    //从n个数里选两个数的组合
    public long c (int n){
        return n > 1 ? (long) n * (n - 1) / 2 : 0;
    }

}
