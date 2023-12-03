package LeetCode75_1.LeetCode345;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }

    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        List<Integer> num = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u' ||
                    chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U')) {
                num.add(i);
                sb.append(chars[i]);
            }
        }
            String t = sb.reverse().toString();
            for (int i = 0; i < num.size(); i++) {
                chars[num.get(i)] = t.charAt(i);
            }
        String res = Arrays.toString(chars);

        return res;
        }
    }
