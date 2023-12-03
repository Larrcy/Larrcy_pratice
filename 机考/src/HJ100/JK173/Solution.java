package HJ100.JK173;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    //任务总执行时长
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        List<Integer> list = new ArrayList<>();
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int n = Integer.parseInt(split[2]);
        for (int i = 0; i <= n; i++) {
            list.add(i * b + (n - i) * a);
        }
        list = list.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(list);
    }

}
