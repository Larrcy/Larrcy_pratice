package day42.LeetCode882;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < fronts.length; ++i)
            if (fronts[i] == backs[i])
                set.add(fronts[i]);

        int ans = Integer.MAX_VALUE;
        for (int x: fronts)
            if (!set.contains(x))
                ans = Math.min(ans, x);

        for (int x: backs)
            if (!set.contains(x))
                ans = Math.min(ans, x);

        return ans==Integer.MAX_VALUE?0:ans;

    }


}
