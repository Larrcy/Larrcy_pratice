package day42.LeetCode397;
import java.util.*;

public class Solution {
    //记忆化搜索记录遍历过的值
    public int integerReplacement(int n) {
        Map<Long, Integer> memo = new HashMap<>();
        return dfs(n, memo);
    }

    private int dfs(long n, Map<Long, Integer> memo) {
        if (n == 1) return 0;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int ans;
        if (n % 2 == 0) {
            ans = dfs(n / 2, memo) + 1;
        } else {
            ans = Math.min(dfs(n + 1, memo), dfs(n - 1, memo)) + 1;
        }
        memo.put(n, ans);
        return ans;
    }


}
