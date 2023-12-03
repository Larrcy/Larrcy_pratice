package HJ100.JK164;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//数组合并
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int num = sc.nextInt();
        sc.nextLine();
        List<List<String>> res = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < num; i++) {
            String s = sc.nextLine();
            String[] split = s.split(",");
            List<String> list = new ArrayList<>(Arrays.asList(split));
            count += (list.size() / len) + (list.size() % len == 0 ? 0 : 1);
            res.add(list);
        }
        StringBuilder sb = new StringBuilder();
        while (count -1> 0) {
            for (int i = 0; i < res.size(); i++) {
                if (res.get(i).size() < len) {
                    while (res.get(i).size() != 0) {
                        sb.append(res.get(i).get(0)).append(",");
                        res.get(i).remove(0);
                    }

                } else {
                    for (int j = 0; j < len; j++) {
                        sb.append(res.get(i).get(0)).append(",");
                        if (res.get(i).size() == 0) break;
                        else res.get(i).remove(0);
                    }

                }
            }
            count--;
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}
