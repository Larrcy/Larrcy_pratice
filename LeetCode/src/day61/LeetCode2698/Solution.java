package day61.LeetCode2698;

/**
 * 给你一个正整数 n ，请你返回 n 的 惩罚数 。
 *
 * n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和：
 *
 * 1 <= i <= n
 * i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。
 */
public class Solution {
    public int punishmentNumber(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            String s = Integer.toString(i * i);
            if (dfs(s, 0, 0, i)) {
                res += i * i;
            }
        }
        return res;
    }

    /**
     * 如果当前的 tot大于 i 时则中止当前的搜索。依次检测在区间 [1,n] 中有多少满足要求的数字 i，并返回这些数字 i 的平方和。
     */
    public boolean dfs(String s, int pos, int tot, int target) {
        //分割到最后一位时与target进行比较
        if (pos == s.length()) {
            return tot == target;
        }
        int sum = 0;
        for (int i = pos; i < s.length(); i++) {
            sum = sum * 10 + s.charAt(i) - '0';
            if (sum + tot > target) {
                break;
            }
            if (dfs(s, i + 1, sum + tot, target)) {
                return true;
            }
        }
        //全部加起来也不满足tot==target 返回false
        return false;
    }

}
