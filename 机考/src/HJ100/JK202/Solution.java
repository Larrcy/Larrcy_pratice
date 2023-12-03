package HJ100.JK202;

import java.util.*;
//***去除多余空格
public class Solution {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String pos = scanner.nextLine();
            solution(line, pos);
        }
    private static void solution(String line, String pos) {
        String[] split = pos.split(",");
        //记录截取的下标所对应的字符串
        String[] keys = new String[split.length];
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] indexes = s.split(" ");
            int l = Integer.parseInt(indexes[0]);
            int r = Integer.parseInt(indexes[1]);
            keys[i] = line.substring(l, r + 1);
        }
        StringBuilder builder = new StringBuilder();
        char[] chars = line.toCharArray();
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '\'') {
                flag = true;
            }
            if (flag) {
                builder.append(c);
                continue;
            }
            //出现连续空格则不记录
            if (c == ' ' && chars[i - 1] == ' ') {
                continue;
            }
            builder.append(c);
        }
        //输出构建好的字符串
        System.out.println(builder);

        for (String key : keys) {
            int l = builder.indexOf(key);
            int r = l + key.length() - 1;
            System.out.println(Arrays.toString(new int[]{l, r}));
        }

    }
}

