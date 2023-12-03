package HJ100.JK115;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//压缩报文还原
public class Solution {
    public static final Pattern PATTERN = Pattern.compile("[0-9]+\\[[a-z]+]");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String res = func(line);
        System.out.print(res);

    }

    private static String func(String line) {
        Matcher matcher = PATTERN.matcher(line);
        if (matcher.find()) {
            String group = matcher.group();
            int pos = group.indexOf('[');
            int times = Integer.parseInt(group.substring(0, pos));
            String words = group.substring(pos + 1, group.length() - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < times; i++) {
                sb.append(words);
            }
            String fixed = line.replace(group, sb.toString());
            return func(fixed);
        } else {
            return line;
        }
    }
}
