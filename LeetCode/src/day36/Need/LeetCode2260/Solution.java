package day36.Need.LeetCode2260;

import java.util.HashMap;

public class Solution {
    public int minimumCardPickup(int[] cards) {
        int ans = -1;
        //用一个map来存储了每个元素出现时的索引值，后边的覆盖前边的，
        //如果map中有相同的元素出现了，说明出现了连续的卡牌，
        //要做的就是计算出来这两个元素之间的距离，然后迭代更新这个两个元素之间的最小距离
        //最后返回即可
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; ++i) {
            if (map.containsKey(cards[i])) {
                int pre = map.get(cards[i]);
                //若ans为-1(刚开始时)需要更新距离
                //若找到更小的距离 再次更新距离
                if (ans == -1 || i - pre + 1 < ans) ans = i - pre + 1;
            }
            map.put(cards[i], i);
        }
        return ans;
    }

}
