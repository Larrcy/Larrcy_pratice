package LeetCode.Test;


import javax.swing.text.rtf.RTFEditorKit;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 */
public class Solution {
    //考虑最后一个数 n =nums[n-1]
    //若n%3==0则n需要选 考虑从nums[0]到nums[n-2]中寻找能被3整除的元素最大和
    //若n%3==1
    //若不选n则考虑从nums[0]到nums[n-2]中寻找能被3整除的元素最大和
    //若选n 则考虑从nums[0]到nums[n-2]中寻找能被3整除余2的元素最大和
    //若n%3==2
    //若不选n则考虑从nums[0]到nums[n-2]中寻找能被3整除的元素最大和
    //若选n 则考虑从nums[0]到nums[n-2]中寻找能被3整除余1的元素最大和
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n+1][3];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (nums[i-1] % 3 == 0) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][0] + nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][1] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][2] + nums[i-1]);
            } else if (nums[i-1] % 3 == 1) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] + nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + nums[i-1]);
            } else if (nums[i-1] % 3 == 2) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + nums[i-1]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2] + nums[i-1]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][0] + nums[i-1]);
            }
        }
        return dp[n][0];
    }




    void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
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

    public int preMax(int i) {
        int res = Integer.MIN_VALUE;
        while (i > 0) {
            res = Math.max(res, tree[i]);
            i &= i - 1;
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










