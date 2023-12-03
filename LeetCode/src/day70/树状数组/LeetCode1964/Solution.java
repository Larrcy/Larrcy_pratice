package day70.树状数组.LeetCode1964;


import java.util.Arrays;

/**
 * 树状数组模板
 * 你打算构建一些障碍赛跑路线。给你一个 下标从 0 开始 的整数数组 obstacles ，数组长度为 n ，其中 obstacles[i] 表示第 i 个障碍的高度。
 *
 * 对于每个介于 0 和 n - 1 之间（包含 0 和 n - 1）的下标  i ，在满足下述条件的前提下，请你找出 obstacles 能构成的最长障碍路线的长度：
 *
 * 你可以选择下标介于 0 到 i 之间（包含 0 和 i）的任意个障碍。
 * 在这条路线中，必须包含第 i 个障碍。
 * 你必须按障碍在 obstacles 中的 出现顺序 布置这些障碍。
 * 除第一个障碍外，路线中每个障碍的高度都必须和前一个障碍 相同 或者 更高 。
 * 返回长度为 n 的答案数组 ans ，其中 ans[i] 是上面所述的下标 i 对应的最长障碍赛跑路线的长度。
 */
public class Solution {
    public static void main(String[] args) {
        int[]obstacles = {1,3,4,1,4};
        System.out.println(longestObstacleCourseAtEachPosition(obstacles));
    }
    public static int[] longestObstacleCourseAtEachPosition(int[] nums) {
        int n = nums.length;
        int[] b = new int[n];
        int[] ans = new int[n];
        System.arraycopy(nums, 0, b, 0, n);
        Arrays.sort(b);
        //将排序后的b重新映射到一个正整数数组上方便利用树状数组
        BIT t = new BIT(b.length + 1);
        for (int i = 0; i < n; i++) {
            //利用二分的方法查找数在数组中的位置利用下标进行重映射
            //这样就可以实现将负数转化成正数利用树状数组进行查询
            int j = Arrays.binarySearch(b, nums[i]) + 1;
            //以nums[i]为结尾的最大值(不含nums[i])
            ans[i] = Math.max(t.query(1, j), 0) + 1;
            //将f更新到树状数组
            t.update(j, ans[i]);
        }
        //最后返回树状数组中最大的前缀和
        return ans;
    }
}


//树状数组模板 最终版
class BIT {
    public int[] tree; // 树状数组
    public final int[] nums; // 原数组
    public int n;

    public BIT(int _n) {
        n = _n;
        tree = new int[n + 1];
        nums = new int[n + 1];
        Arrays.fill(tree, Integer.MIN_VALUE);
        Arrays.fill(nums, Integer.MIN_VALUE);
    }

    // 返回闭区间 [1, i] 的元素和
    public int sum(int x) {
        int res = 0;
        while (x > 0) {
            res += tree[x];
            x &= x - 1;
        }
        return res;
    }

    // 返回闭区间 [left, right] 的元素和
    public int querySum(int left, int right) {
        return sum(right) - sum(left - 1);
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

    // 将下标 i 上的数加一
    public void inc(int i) {
        while (i < tree.length) {
            ++tree[i];
            i += i & -i;
        }
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









