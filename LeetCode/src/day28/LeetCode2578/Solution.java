package day28.LeetCode2578;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int splitNum(int num) {
        // Integer.toString(num).toCharArray()将数转换成数组
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10);
            num = num / 10;
        }
        Collections.sort(list);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) continue;
            if (i % 2 != 0) num1 = num1 * 10 + list.get(i);
            if (i % 2 == 0) num2 = num2 * 10 + list.get(i);
        }
        return num1 + num2;
    }
}
