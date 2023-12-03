package day43.LeetCode1807;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "hi(name)";
        List<List<String>> knowledge = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        knowledge.add(list);
        System.out.println(evaluate(s, knowledge));
        // s = s.replace(s.substring(left + 1, right), swap(sb.substring(left + 1, right)));
    }

    public static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>(knowledge.size());
        for (List<String> e : knowledge) {
            map.put(e.get(0), e.get(1));
        }


        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(')', i + 1);
                ans.append(map.getOrDefault(s.substring(i + 1, j), "?"));
                i = j;
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }


}
