package HJ100.JK015;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
//第k长子串
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(func(s, k));
    }

    public static int func(String s, int k) {
        if (k > s.length()) return -1;
        Map<Character, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
                i++;
            }
            if (!map.containsKey(s.charAt(i - 1))) {
                map.put(s.charAt(i - 1), count);
            } else {
                if (count > map.get(s.charAt(i - 1))) {
                    map.put(s.charAt(i - 1), count);
                }
            }
            count = 1;
        }
        List<Map.Entry<Character, Integer>> list = map.entrySet().stream().sorted(((o1, o2) -> o2.getValue() - o1.getValue())).collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if (k - 1 == i) {
                return list.get(i).getValue();
            }
        }

        return 0;
    }
}
