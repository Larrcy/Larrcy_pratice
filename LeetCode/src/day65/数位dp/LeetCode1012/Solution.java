package day65.数位dp.LeetCode1012;

import java.util.Arrays;

public class Solution {
    char[] s; // 把给定的整数n转化为字符串数组
    int[][] dp;

    public int numDupDigitsAtMostN(int n) {
        // 把给定的整数n转化为字符串数组
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        //0-9十个数对应十个位置
        dp = new int[m][1 << 10];
        // 初始化dp
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1); // -1表示没有计算过
        // 先算出1-n之间没有重复数字的个数a 则return n-a;
        return n - f(0, 0, true, false); // 这里isLimit为什么要初始化为true:如果是false,那马上要填的这个填0~9就都可以了,不受[1,n]的约束,显然不对
    }

    // 前置知识:位运算与集合论
    // 集合和二进制一一对应 因此之前填过的数字(集合)可以用一个int mask表示
    // 二进制从低到高第i位为1表示i在集合中，为0表示i不在集合中。例如集合{0,2,3}对应的二进制数为1101

    /**
     * 本题用到的:
     * (1)判断数字d是否在集合mask中: mask >> d & 1 可以取出 mask 的第 d 个比特位，如果是 1 就说明 d 在集合mask中
     * (2)把数字d添加到集合mask中: mask 更新为 mask | (1 << d)
     */
    // 从i开始填数字，i前面填过的数字集合是mask
    // isLimit表示前面填的数字是否都是n对应位上的:isLimit==true，那么当前位至多为s[i]
    // (eg:n=123,前两位填的数字都是n对应位上的填了12,那么当前位只能填0~s[i]即0~3了);isLimit==false,当前位可以从0~9选填,至多为'9'
    // isNum表示前面是否填了数字(是否跳过,是否是一个合法数字 比如010就不合法)
    public int f(int i, int mask, boolean isLimit, boolean isNum) {
        // 终点
        if (i == s.length)
            //isNum表示前面是否填了数字
            // isNum==true,那么当前位可以从0开始；isNum==false,那么我们可以跳过这位也不填，或者这位从1~9选填
            return isNum ? 1 : 0; // 之前填过数字,那么就有一个合法数字了

        // 前面既没有填n对应位上的数，又填了数，那么后面填的都不受限
        if (!isLimit && isNum && dp[i][mask] != -1)
            return dp[i][mask];

        int ans = 0;
        //前面没有填数选择跳过当前位,也不填数字
        if (!isNum)
            ans = f(i + 1, mask, false, false);
        // 上界:当前位i能填的数字的上界
        int up = isLimit ? s[i] - '0' : 9; // 也就是上面解释的isLimit的含义
        // 下面就可以开始枚举要填入的数字d了
        //前面填了数字可以从0开始没填从1开始
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            //判断当前数是否在集合内=0不在 =1在
            //当不在集合时 将d添加进集合 判断d是否是上界
            if ((mask >> d & 1) == 0) // d不在mask里
                ans += f(i + 1, mask | (1 << d), isLimit && (d == up), true);
        }
        //前面填了数且前面填的数不受限制
        //更新dp[i]
        if (!isLimit && isNum)
            dp[i][mask] = ans;
        return ans;
    }
}
