package day89.LeetCode2064;

/**
 * 给你一个整数 n ，表示有 n 间零售商店。总共有 m 种产品，每种产品的数目用一个下标从 0 开始的整数数组 quantities 表示，其中 quantities[i] 表示第 i 种商品的数目。
 *
 * 你需要将 所有商品 分配到零售商店，并遵守这些规则：
 *
 * 一间商店 至多 只能有 一种商品 ，但一间商店拥有的商品数目可以为 任意 件。
 * 分配后，每间商店都会被分配一定数目的商品（可能为 0 件）。用 x 表示所有商店中分配商品数目的最大值，你希望 x 越小越好。也就是说，你想 最小化 分配给任意商店商品数目的 最大值 。
 * 请你返回最小的可能的 x 。
 */
public class Solution {
    //假设每家店尽可能最多分配x件同类商品时，所有商品需要被分配到k家店才分配完，那么：
    //若k > n
    //说明题目给定的店铺不足以分完全部商品，也就是每家店分得太少了
    //因此需增大x（即二分法的范围右移）；
    //若k <= n
    //说明x过大、导致有的店分不到商品了
    //此时为了最小化分配商品的最大值，可尝试通过减少x
    //让这几家空着的店也分摊一些商品（即二分法范围左移）。
      public int minimizedMaximum(int n, int[] quantities) {
          //分配左右边界
          //由题意知最小值为1 最大值为所有商品的总数
          long left = 1;
          long right = 0;
          for (int q : quantities) right += q;
          while (left <= right) {
              long mid = (left + right) / 2;
              // 每家店分mid件商品，一共需要k家店才能分完
              int k = 0;
              for (int num : quantities)
                  //单独计算每种商品需要多少家店才能分完
                  //不能用总数除mid
                  k += Math.ceil((double) num/mid);
              if (k > n) {
                  //此时每家店分配的商品太少 需要多分配商品
                  left = mid + 1;
              } else {
                  //此时满足条件 但每家店分配的商品过多 需要适当减少商品
                  right = mid-1;
              }
          }
          //最后左指针所指的位置即为满足要求的分配方案
          return (int)left;
    }
}
