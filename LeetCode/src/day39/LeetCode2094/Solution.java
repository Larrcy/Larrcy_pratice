package day39.LeetCode2094;

import java.util.*;

public class Solution {
    public int[] findEvenNumbers(int[] digits) {
        boolean exsit[] = new boolean[1005];
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits.length; j++) {
                for (int k = 0; k < digits.length; k++) {
                    if (i != j && j != k && i != k) {
                        exsit[100 * digits[i] + 10 * digits[j] + digits[k]] = true;
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        //遍历100-999的所有偶数
        for (int i = 100; i < 1000; i++) {
            if (exsit[i]) {
                list.add(i);
            }
        }
        int ans[] = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
