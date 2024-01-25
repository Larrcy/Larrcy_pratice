package 模板.线段树.LeetCode2569;
//lazy 线段树
//主要解决 在一个数组中，更新一个子数组的值
//如 把子数组的元素都加上1或者取反
//   查询一个子数组的值 求和 求最大值等
//思想
//1. 挑选O(N)个特殊区间 是的任意一个区间可以拆分为O(logN)个特殊区间
//其中O(N)<=4N
//之后选择O(N)个特殊区间build
//2. lazy更新
//lazy tag：用一个数组维护每个区间需要更新的值
//若该值为0则不用更新
//若不为0则则表示更新操作在这个区间暂停 不继续递归
//若后面还有更新破坏了lazy tag则这个区间需要继续递归更新

public class Solution {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length, m = 0, i = 0;
        cnt1 = new int[n * 4];
        flip = new boolean[n * 4];
        build(nums1, 1, 1, n);

        long sum = 0L;
        //先对nums2求和
        for (int x : nums2)
            sum += x;

        for (int[] q : queries)
            //统计操作3有多少个
            if (q[0] == 3) ++m;

        long[] ans = new long[m];

        for (int[] q : queries) {
            //开区间 因此要加1
            if (q[0] == 1) update(1, 1, n, q[1] + 1, q[2] + 1);
            else if (q[0] == 2) sum += (long) q[1] * cnt1[1];
            else {
                ans[i] = sum;
                i++;
            }
        }
        return ans;
    }
    //cnt1用于统计区间内1的个数
    private int[] cnt1;
    private boolean[] flip;

    // 维护区间 1 的个数
    private void maintain(int o) {
        cnt1[o] = cnt1[o * 2] + cnt1[o * 2 + 1];
    }

    // 执行区间反转
    private void do_(int o, int l, int r) {
        //将所有的1翻转成0 所有的0反转成1
        //则反转后1的个数等于原来0的个数
        cnt1[o] = r - l + 1 - cnt1[o];
        flip[o] = !flip[o];
    }

    // 初始化线段树   o,l,r=1,1,n
    private void build(int[] a, int o, int l, int r) {
        if (l == r) {
            cnt1[o] = a[l - 1];
            return;
        }
        int m = (l + r) / 2;
        build(a, o * 2, l, m);
        build(a, o * 2 + 1, m + 1, r);
        maintain(o);
    }

    // 反转区间 [L,R]   o,l,r=1,1,n
    private void update(int o, int l, int r, int L, int R) {
        //若l,r落在L,R内 则进行反转
        if (L <= l && r <= R) {
            do_(o, l, r);
            return;
        }
        int m = (l + r) / 2;
        if (flip[o]) {
            do_(o * 2, l, m);
            do_(o * 2 + 1, m + 1, r);
            flip[o] = false;
        }
        if (m >= L) update(o * 2, l, m, L, R);
        if (m < R) update(o * 2 + 1, m + 1, r, L, R);
        maintain(o);
    }
}
