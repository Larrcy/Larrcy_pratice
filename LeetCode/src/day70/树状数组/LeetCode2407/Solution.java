package day70.树状数组.LeetCode2407;


import java.util.Arrays;

/**
树状数组模板
 给你一个整数数组 nums 和一个整数 k 。

 找到 nums 中满足以下要求的最长子序列：

 子序列 严格递增
 子序列中相邻元素的差值 不超过 k 。
 请你返回满足上述要求的 最长子序列 的长度。

 子序列 是从一个数组中删除部分元素后，剩余元素不改变顺序得到的数组。
 */
public class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int N = nums.length;
        BIT tr = new BIT(N);
        for (int num : nums) {
            int max = tr.query(Math.max(1, num - k), num - 1);
            tr.update(num, max + 1);
        }
        return tr.query(1, N);
    }

  //树状数组模板 最终版
    class BIT {
        private int[] tree; // 树状数组
        private int[] nums; // 原数组
        private int n;

        public BIT(int _n) {
            n = _n;
            tree = new int[n + 1];
            nums = new int[n + 1];
            Arrays.fill(tree, Integer.MIN_VALUE);
            Arrays.fill(nums, Integer.MIN_VALUE);
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

        private int lowbit(int x) {
            return x & -x;
        }

        // 目标值定义, 此例为最大值
        private int choose(int a, int b) {
            return Math.max(a, b);
        }

        // 查询[a, b]之间的目标值
        public int query(int a, int b) {
            int ret = nums[b];
            while (b >= a) {
                ret = choose(ret, nums[b]);
                b--;
                for (; b - lowbit(b) >= a; b -= lowbit(b)) {
                    ret = choose(ret, tree[b]);
                }
            }
            return ret;
        }

        // 修改下标为idx的数为val
        public void update(int idx, int val) {
            nums[idx] = val;
            tree[idx] = val;
            while (idx <= n) {
                int lx = lowbit(idx);
                for (int i = 1; i < lx; i <<= 1) {
                    tree[idx] = choose(tree[idx], tree[idx - i]);
                }
                idx += lx;
            }
        }
    }


}





