package HJ100.JK209;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//找出通过车辆最多的颜色
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 while 处理多个 case
        String str = sc.nextLine();
        int b = sc.nextInt();
        System.out.println(fun(str, b));

    }


    public static int fun(String str, int b) {
        String[] s = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length; i++) {
            String cur = s[i];
            if (i >= b) {
                map.put(s[i - b], map.getOrDefault(s[i - b], map.get(s[i - b])) - 1);
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            max = Math.max(max, map.get(cur));
        }
        return max;
    }

}
