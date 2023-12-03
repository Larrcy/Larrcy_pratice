package HJ.JK002;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int id = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = sc.nextLine();
        }
        System.out.println(func(strs, id));

    }

    public static long func(String[] strs, int id) {
        long count = 0;
        for (int i = 0; i < strs.length; i++) {
            String[] split = strs[i].split(" ");
            if (Integer.parseInt(split[0]) == id) {
                count += Integer.parseInt(split[1]);
                while (split[2].length() > 2) {
                    split[2] = split[2].substring(1, split[2].length() - 1);
                    String[] ss = split[2].split(",");
                    if(ss.length==0)continue;
                    for (int j = 0; j < ss.length; j++) {
                        if(ss[j].length()==0)continue;
                        count += func(strs, Integer.parseInt(ss[j]));
                    }

                }
            }
        }
        return count;
    }
}






