package 基础算法.KMP;

//KMP算法
public class Solution {
    public static void main(String[] args) {
        String haystack = "aabaabaaf";
        String needle = "aabaaf";
        System.out.println(strStr(haystack, needle));
    }

    //找到needle中第一个与haystack匹配的下标
    public static int strStr(String str1, String str2) {
        if (str2.length() == 0) return 0;
        int j = 0;
        int[] next = new int[str2.length()];
        getNext(next, str2);
        for (int i = 0; i < str1.length(); i++) {
            while (j > 0 && str2.charAt(j) != str1.charAt(i)) {
                j = next[j - 1];
            }
            if (str2.charAt(j) == str1.charAt(i)) {
                j++;
            }
            if (j == str2.length()) {
                return i - str2.length() + 1;
            }
        }
        return -1;

    }

    //KMP的next数组
    public static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                next[i] = j;
            }
        }
    }
}
