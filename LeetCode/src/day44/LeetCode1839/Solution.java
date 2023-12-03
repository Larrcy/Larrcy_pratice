package day44.LeetCode1839;

public class Solution {
    public int longestBeautifulSubstring(String word) {
        int ans = 0, type = 1, len = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) >= word.charAt(i - 1)) len++; //更新当前字符串长度
            if (word.charAt(i) > word.charAt(i - 1)) type++; //更新当前字符种类
            if (word.charAt(i) < word.charAt(i - 1)) {
                type = 1;
                len = 1;
            } //当前字符串不美丽，从当前字符重新开始
            if (type == 5) ans = Math.max(ans, len);  //更新最大字符串
        }
        return ans;
    }

}
