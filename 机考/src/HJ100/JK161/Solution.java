package HJ100.JK161;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String news = sc.nextLine();
        String ano = sc.nextLine();
        String[] split1 = news.split(" ");
        String[] split2 = ano.split(" ");
        System.out.println(func(split1, split2));

    }

    public static boolean func(String[] split1, String[] split2) {
        int sum = 0;
        for (int i = 0; i < split2.length; i++) {
            for (int j = 0; j < split1.length; j++) {
                int[] cnt = new int[26];
                for (int k = 0; k < split2[i].length(); k++) {
                    cnt[split2[i].charAt(k) - 'a']++;
                }
                for (int k = 0; k < split1[j].length(); k++) {
                    cnt[split1[j].charAt(k) - 'a']--;
                }
                int count = 0;
                for (int k = 0; k < cnt.length; k++) {
                    if (cnt[k] == 0) {
                        count++;
                    }
                }
                if (count == 26) {
                    sum++;
                }
                split1[j]="";
            }
        }
        return sum == split2.length;
    }
}
