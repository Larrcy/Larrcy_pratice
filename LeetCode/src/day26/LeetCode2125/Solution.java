package day26.LeetCode2125;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numberOfBeams(String[] bank) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < bank.length; i++) {
            int count = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    count++;
                }
            }
            if (count != 0) list.add(count);

        }
        if (list.size() == 1 || list.size() == 0) return 0;
        int res = 0;
        for (int p = 0,q=1; q < list.size(); p++,q++) {
            res = res +list.get(p)*list.get(q);
        }
        return res;

    }
}
