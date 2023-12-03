package LeetCode75_1.LeetCode1431;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            candies[i] = candies[i] + extraCandies;
            if (max < candies[i]) {
                max = candies[i];
            }
        }
        for (int j = 0; j < candies.length; j++) {
            if (max - candies[j] > extraCandies) {
                list.add(false);
            } else list.add(true);
        }
        return list;
    }
}
