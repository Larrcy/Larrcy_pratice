package day43.LeetCode1190;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        String s = "a(sssss(mno)p)q";
        System.out.println(reverseParentheses(s));
    }

    public static String reverseParentheses(String s) {
        Deque<String> stack = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (ch == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
