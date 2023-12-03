package day30.LeetCode1093;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public double[] sampleStats(int[] count) {
        double[] res = new double[5];
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                res[0] = i;
                break;
            }
        }
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] != 0) {
                res[1] = i;
                break;
            }
        }
        double sum = 0;
        double num = 0;
        for (int i = 0; i < count.length; i++) {
            sum += (long) i * count[i];
            num += count[i];
        }
        if (num != 0) {
            res[2] = sum / num;
        } else {
            res[2] = 0;
        }

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                map.put(i, count[i]);
        }
        double target =num/2;
        int index=1;
        for (Integer key : map.keySet()) {
            if (num % 2 == 0) {
                target-= map.get(key);
                if (target == 0) {
                    res[3] = key;
                    index++;
                }
                if (target < 0) {
                    res[3] = res[3] + key;
                    res[3] = res[3] / index;
                    break;
                }
            }
            if (num % 2 != 0) {
                target -= map.get(key);
                if (target < 0) {
                    res[3] = key;
                    break;
                }
            }
        }


        int max = -1;
        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = Math.max(max, count[i]);
                res[4] = i;
            }
        }

        return res;
    }
}
