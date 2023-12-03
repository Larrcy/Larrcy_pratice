package day36.Need.LeetCode1052;

public class Solution {
    //由于「技巧」只会将情绪将「生气」变为「不生气」，不生气仍然是不生气。
    //我们可以先将原本就满意的客户加入答案，同时将对应的 customers[i]变为 0。
    //之后的问题转化为：在 customers中找到连续一段长度为 minutes的子数组，使得其总和最大。
    //这部分就是我们应用技巧所得到的客户。

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length, ans = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
                customers[i] = 0;
            }
        }
        int cur = 0, max = 0;
        for (int i = 0; i < n; i++) {
            cur += customers[i];
            if (i == minutes) cur -= customers[i - minutes];
            max = Math.max(max, cur);
        }
        return ans + max;
    }

}
