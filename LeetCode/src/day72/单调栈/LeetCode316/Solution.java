package day72.单调栈.LeetCode316;

import java.util.Stack;

/**
 * 自定义单调栈
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("edebbed"));
    }
    public static String removeDuplicateLetters(String s) {
        //首先记录每个字符出现的次数
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //出现重复元素则跳过并让字符数减少一次
            if (stack.contains(c)) {
                cnt[c - 'a']--;
                continue;
            }
            //栈内维护字符从小到大的顺序
            //若遍历到的字符比栈顶元素小且该字符剩余的出现次数大于1则可以将该字符弹出
            //若仅为1次则不弹出
            while (!stack.isEmpty() && cnt[stack.peek() - 'a'] > 1 && stack.peek() > c) {
                cnt[stack.peek() - 'a']--;
                stack.pop();
            }
            stack.push(c);
        }
        //最后收集结果
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
