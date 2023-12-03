package day69.LeetCode2735;

/**
 * 给你一个长度为 n 、下标从 0 开始的整数数组 nums ，表示收集不同巧克力的成本。每个巧克力都对应一个不同的类型，最初，位于下标 i 的巧克力就对应第 i 个类型。
 * <p>
 * 在一步操作中，你可以用成本 x 执行下述行为：
 * <p>
 * 同时修改所有巧克力的类型，将巧克力的类型 ith 修改为类型 ((i + 1) mod n)th。
 * 假设你可以执行任意次操作，请返回收集所有类型巧克力所需的最小成本。
 */
public class Solution {
    //设nums={20，1，15} x=5
    //初始状态
    //0  1  2
    //20 1  15
    //我们只需要不断的向移动下标(最多n-1)i次
    //计算sum =i*x+min(num[i])的最小值即可
    //如不移动sum= 20+1+15=36
    //移动一次sum= 5+1+1+15=22
    //移动2次 sum=5*2+1+1+1=13
    public long minCost(int[] nums, int x) {
        long ans = Long.MAX_VALUE;
        int n = nums.length;
        long[] cont = new long[n];
        for (int i = 0; i < n; i++) {
            cont[i] = nums[i];
        }
//总的遍历逻辑是，先便利次数，在遍历整个数组，动态维护最小值和本次数组最小和
//这样即可将整个前缀数组的最小值min（）优化为两个值的比大小O(1)的时间复杂度
        for (int i = 0; i < n; i++) {// 枚举次数
            long curNum = 0;
            for (int j = 0; j < n; j++) {// 枚举整个数组
                //用本次遍历到的数与上次移动的最小值取最小值
                cont[j] = Math.min(cont[j], nums[(i + j) % n]);
                curNum += cont[j];
            }
            ans = Math.min(curNum + (long) x * i, ans);
            // System.out.println(Arrays.toString(cont));
        }
        return ans;
    }
}
