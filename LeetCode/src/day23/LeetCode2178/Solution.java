package day23.LeetCode2178;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //贪心法
    //1.若finalsum为奇数则无法拆分成若干偶数直接返回空
    //2.若为偶数 则我们尽可能的拆分成最小的若干偶数
    //从2开始依次拆分 直到剩余的数值小于等于当前被拆分的最大偶数
    //若拆分后剩余的finalsum大于0则将该数加到最大的偶数上

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 > 0) {
            return res;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
        return res;
    }

}

