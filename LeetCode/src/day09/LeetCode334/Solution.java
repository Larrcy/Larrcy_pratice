package day09.LeetCode334;

public class Solution {
    public static void main(String[] args) {

    }
    //时间复杂度O(N)
    //空间复杂度O(N)
    public void reverseString(char[] s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
        }
        StringBuilder reverse = sb.reverse();
        for (int i = 0; i < reverse.length(); i++) {
            s[i] = reverse.charAt(i);
        }


    }
}
