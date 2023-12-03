package day09.LeetCode459;

public class Solution2 {
    public static void main(String[] args) {
String s = "ababab";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        if(s.length()==0){
            return false;
        }
        int[] next = new int[s.length()];
        getNext(next, s);
        int len =next.length-1;
        //最长相等前后缀不包含的部分即为重复子串
        //若原字符串长度能够整除最长相等前后缀不包含的那部分的长度则为重复子串
        if (next[len - 1] != 0 && s.length() % (s.length() - next[len]) == 0) {
            return true;
        }
        return false;

    }

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
