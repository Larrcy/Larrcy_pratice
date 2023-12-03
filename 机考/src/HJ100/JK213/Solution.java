package HJ100.JK213;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(func(s));


    }

    public static int func(String s) {
        Stack<Character> stack = new Stack<>();
        int countM = 0;
        int countI = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'M') countM++;
            if (s.charAt(i) == 'I') countI++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == 'I') {
                    stack.pop();
                    stack.push(s.charAt(i));
                } else if (s.charAt(i) == 'M' && stack.peek() == 'M') {
                    stack.push(s.charAt(i));
                } else if (s.charAt(i) == 'M' && stack.peek() == 'I') {
                    stack.pop();
                }
            }

        }
        if (stack.isEmpty()) {
            return Math.min(countI, countM);
        } else {
            while (!stack.isEmpty()&&stack.peek() == 'I') {
                stack.pop();
            }
            if (!stack.isEmpty()) return -1;
            else return Math.min(countI, countM);
        }
    }
}
