package day80.LeetCode2786;

import java.util.PriorityQueue;

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个正整数 x 。
 * <p>
 * 你 一开始 在数组的位置 0 处，你可以按照下述规则访问数组中的其他位置：
 * <p>
 * 如果你当前在位置 i ，那么你可以移动到满足 i < j 的 任意 位置 j 。
 * 对于你访问的位置 i ，你可以获得分数 nums[i] 。
 * 如果你从位置 i 移动到位置 j 且 nums[i] 和 nums[j] 的 奇偶性 不同，那么你将失去分数 x 。
 * 请你返回你能得到的 最大 得分之和。
 * <p>
 * 注意 ，你一开始的分数为 nums[0] 。
 */
public class Solution {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int n = nums1.length;
        int t =0;
        for (int i = 0; i < n; i++) {
            int a = nums1[i];
            int b = nums2[i];
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            if (pq.isEmpty()) {
                pq.add(min);
                res++;
            } else {
               if(max<pq.peek()){
                   t=Math.max(res,t);
                   pq.clear();
                   res=0;
               }else if(min>= pq.peek()){
                   pq.add(min);
                   res++;
               }else if(max>= pq.peek()){
                   pq.add(max);
                   res++;
               }

            }
        }
        return t;
    }
}
