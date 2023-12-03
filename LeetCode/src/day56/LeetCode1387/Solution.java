package day56.LeetCode1387;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getKth(12, 15, 2));
    }

    public static int getKth(int lo, int hi, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = lo; i <= hi; i++) {
            map.put(i, gcd(i));
        }
        //将map存入list集合并按照值排序
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().sorted(((o1, o2) -> o1.getValue() - o2.getValue())).collect(Collectors.toList());
        for (Map.Entry<Integer, Integer> maps : list) {
            k -= 1;
            if (k == 0) {
              return maps.getKey();
            }
        }

        return -1;
    }

    public static int gcd(int n) {
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            count++;
        }
        return count;
    }
}
