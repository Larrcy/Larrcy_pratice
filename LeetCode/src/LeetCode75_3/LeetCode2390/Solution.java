package LeetCode75_3.LeetCode2390;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String s ="leet**cod*e";
        System.out.println(removeStars(s));
    }
    public static String removeStars(String s) {
        Stack<Character>stack =new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!='*'){
                stack.push(s.charAt(i));
            }else {
                stack.pop();
            }
        }
        StringBuilder sb= new StringBuilder();
       while (!stack.isEmpty()){
        sb.append(stack.pop());

       }
        return sb.reverse().toString();
    }
}
