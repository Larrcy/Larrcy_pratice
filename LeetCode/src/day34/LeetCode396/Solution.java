package day34.LeetCode396;

public class Solution {
    //旋转数组可以考虑将nums进行复制拼接 得到长度为2n的新数组
    //第i个结果为
    //cur[i]=nums[i]∗0+nums[i+1]∗1+...+nums[i+n−1]∗(n−1)
    //下一个结果只需要将窗口后移一位即可
    //即cur[i]=nums[i]∗0+nums[i+1]∗1+...+nums[i+n−1]∗(n−1)
    //变为 cur[i+1]=nums[i+1]∗0+...+nums[i+n−1]∗(n−2)+nums[i+n]*(n-1)
    //公共部分的差值为 nums[i+1]+nums[i+2]+...+nums[i+n-1]
    //即公共部分的差值为[i,i+n-1]的前缀和
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        //定义前缀和sum
        int[] sum = new int[n * 2 + 1];
        for (int i = 1; i <= 2 * n; i++) sum[i] = sum[i - 1] + nums[(i - 1) % n];
        //对每一部分进行求和取最大值
        int ans = 0;
        //起始位置的和 即nums[0]∗0+nums[1]∗1+...+nums[n-1]∗(n-1)
        for (int i = 1; i <= n; i++) ans += nums[i - 1] * (i - 1);

        for (int i = n + 1, cur = ans; i < 2 * n; i++) {
            //加上下一位的元素
            cur += nums[(i - 1) % n] * (n - 1);
            //减去前缀和此时是[i-n+1,i-1]
            //故为sum[i - 1] - sum[i - n]
            cur -= sum[i - 1] - sum[i - n];
            if (cur > ans) ans = cur;
        }
        return ans;
    }
}



