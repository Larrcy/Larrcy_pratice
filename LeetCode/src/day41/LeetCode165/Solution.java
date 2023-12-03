package day41.LeetCode165;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int[] num1 = new int[split1.length];
        int[] num2 = new int[split2.length];
        for (int i = 0; i < split1.length; i++) {
            num1[i] = Integer.parseInt(split1[i]);
        }
        for (int i = 0; i < split2.length; i++) {
            num2[i] = Integer.parseInt(split2[i]);
        }
        int len = Math.min(num1.length, num2.length);
        for (int i = 0; i < len; i++) {
            if (num1[i] == num2[i]) continue;
            if (num1[i] > num2[i]) return 1;
            if (num1[i] < num2[i]) return -1;
        }
        if (len == num2.length) {
            for (int i = num2.length; i < num1.length; i++) {
                if (num1[i] == 0) continue;
                if (num1[i] != 0) return 1;
            }
        } else {
            for (int i = num1.length; i < num2.length; i++) {
                if (num2[i] == 0) continue;
                if (num2[i] != 0) return -1;
            }

        }
        return 0;

    }
}
