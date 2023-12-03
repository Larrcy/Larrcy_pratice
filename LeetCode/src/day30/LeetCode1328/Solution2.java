package day30.LeetCode1328;

public class Solution2 {
    //如果字符串长度为奇数，则字符串中间的那个字符无论怎么改，字符串都是回文串。
    // 如：aba，b字符无论怎么改，字符串都还是回文串。
    //回文串前半段和后半段是相互对应的，因此只要遍历一半就好了。
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length(), half = len >> 1;
        if (len < 2) return "";
        char[] ch_arr = palindrome.toCharArray();
        for (int i = 0; i < half; ++i)
            if (ch_arr[i] > 'a') {
                ch_arr[i] = 'a';
                return String.valueOf(ch_arr);
            }
        ch_arr[len - 1] = 'b';
        return String.valueOf(ch_arr);
    }

}
