package HJ100.JK026;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(sc.nextInt());
        }
        int n = sc.nextInt();
        System.out.println(func(list, n));
    }

    public static int func(List<Integer> list, int n) {
        list = list.stream().distinct().sorted().collect(Collectors.toList());
        if (list.size() < n * 2) return -1;
        int max = 0;
        int min = 0;
        for (int i = 0; i < n; i++) {
            min += list.get(i);
        }
        for (int i = list.size() - 1; i >= list.size() - n; i--) {
            max += list.get(i);
        }
        return min + max;
    }
}
