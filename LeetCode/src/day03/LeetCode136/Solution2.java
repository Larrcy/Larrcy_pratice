package day03.LeetCode136;

import java.util.*;

public class Solution2 {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            //异或
            single ^= num;
        }
        return single;
    }


}
