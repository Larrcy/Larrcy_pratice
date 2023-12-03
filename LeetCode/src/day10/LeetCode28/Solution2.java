package day10.LeetCode28;

public class Solution2 {
    public static void main(String[] args) {
String haystack = "aabaaf", needle = "aaf";
        System.out.println(strStr(haystack, needle));

    }

    //KMP算法
    public static int strStr(String haystack, String needle) {
        //needle为空则返回0
        if (needle.length() == 0) return 0;

        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            //若出现不匹配的字符则j进行回退
            //直到退到j=0或者出现相等的情况
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;

    }

    private static void getNext(int[] next, String s) {
        //初始化next数组
        //i指向后缀末尾位置
        //j指向前缀末尾位置
        //i从1开始 j从0开始才能进行匹配
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i))
                //若ij所知位置元素不相等则j向前回退
                //j要看j前一位的值
                j = next[j - 1];
            //若相等则j++ 并将j的值赋给next
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }
}
