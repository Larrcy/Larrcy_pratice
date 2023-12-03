package day70.树状数组.LeetCode2926;

import java.util.Arrays;

/**
 *给你一个下标从 0 开始的整数数组 nums 。
 *
 * nums 一个长度为 k 的 子序列 指的是选出 k 个 下标 i0 < i1 < ... < ik-1 ，如果这个子序列满足以下条件，我们说它是 平衡的 ：
 *
 * 对于范围 [1, k - 1] 内的所有 j ，nums[ij] - nums[ij-1] >= ij - ij-1 都成立。
 * nums 长度为 1 的 子序列 是平衡的。
 *
 * 请你返回一个整数，表示 nums 平衡 子序列里面的 最大元素和 。
 *
 * 一个数组的 子序列 指的是从原数组中删除一些元素（也可能一个元素也不删除）后，剩余元素保持相对顺序得到的 非空 新数组。
 */
public class Solution {
    //定义 b[i]=nums[i]−i，
    //问题转换成从 b 中选出一个非降子序列，求对应 nums 的元素和的最大值。
    //如果 i 是子序列最后一个数的下标，考虑倒数第二个数的下标 j，
    //如果 b[j]≤b[i]，
    //那么就找到了一个子问题：子序列最后一个数的下标是 j 时，对应的 nums 的元素和的最大值。
    //状态转移方程：Math.max(t.preMax(j), 0) + nums[i]
    //nums[i]有负数需要进行离散化转成正整数
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = nums[i] - i;
        }
        Arrays.sort(b);
        //将排序后的b重新映射到一个正整数数组上方便利用树状数组
        BIT t = new BIT(b.length + 1);
        for (int i = 0; i < n; i++) {
            //利用二分的方法查找数在数组中的位置利用下标进行重映射
            //这样就可以实现将负数转化成正数利用树状数组进行查询
            int j = Arrays.binarySearch(b, nums[i] - i) + 1;
            long f = Math.max(t.preMax(j), 0) + nums[i];
            //将f更新到树状数组
            t.update(j, f);
        }
        //最后返回树状数组中最大的前缀和
        return t.preMax(b.length);
    }
}
// 树状数组模板（维护前缀最大值）
class BIT {
    private long[] tree;

    public BIT(int n) {
        tree = new long[n];
        Arrays.fill(tree, Long.MIN_VALUE);
    }

    //往arr[i]里添加val并维护前缀和
    public void update(int i, long val) {
        //更新操作 每次往这个数上加lowbit直到最后
        while (i < tree.length) {
            tree[i] = Math.max(tree[i], val);
            i += i & -i;
        }
    }

    //维护树状数组前缀和的最大值
    //例如我们要求pre[7]即前7个数的和
    //pre[7]=num[7]+tree[6]+tree[4]
    //我们在找前缀的时候每次删除最低位的1
    //111->110->100->0 到0的时候跳出
    //即7->6->4
    public long preMax(int i) {
        long res = Long.MIN_VALUE;
        while (i > 0) {
            res = Math.max(res, tree[i]);
            i &= i - 1;
        }
        return res;
    }

    //查询前缀和pre[i]
    public long query(int i) {
        long res = 0;
        while (i > 0) {
            res += tree[i];
            i &= i - 1;
        }
        return res;
    }


}
