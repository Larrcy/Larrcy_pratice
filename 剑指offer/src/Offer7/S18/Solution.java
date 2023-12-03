package Offer7.S18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<String> res = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(permutation(s));

    }


    public static String[] permutation(String s) {
        boolean[] used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = "";
        for (int i = 0; i < chars.length; i++) {
            s += chars[i];
        }
        backtracking(s, used);
        return res.toArray(new String[res.size()]);
    }

    public static void backtracking(String s, boolean[] used) {
        if (sb.length() == s.length()) {
            res.add(sb.toString());
        }
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1) && used[i - 1] == false) {
                continue;
            }
            if (used[i] == false) {
                used[i] = true;
                sb.append(s.charAt(i));
                backtracking(s, used);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }

        }
    }
}
