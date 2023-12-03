package HJ100.JK198;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        TreeMap<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < split.length; i++) {
            map.put(split[i], map.getOrDefault(split[i], 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            if (map.get(key) >= 4) {
                for (Integer i = 0; i < map.get(key); i++) {
                    sb.append(key).append(" ");
                }
                map.remove(key);
            }
        }
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 3) {
                list.add(key);
            } else if (map.get(key) == 2) {
                list2.add(key);
            } else {
                list3.add(key);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 3; j++) {
                    sb.append(list.get(i)).append(" ");
                }
            } else {
                for (int j = 0; j < 2; j++) {
                    sb.append(list.get(i)).append(" ");
                }
                list3.add(list.get(i));
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            for (int j = 0; j < 2; j++) {
                sb.append(list2.get(i)).append(" ");
            }
        }
        Collections.sort(list3);
        Collections.reverse(list3);
        for (int i = 0; i < list3.size(); i++) {
            sb.append(list3.get(i)).append(" ");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));

    }
}
