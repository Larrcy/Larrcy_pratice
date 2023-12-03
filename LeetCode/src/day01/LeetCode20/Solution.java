package day01.LeetCode20;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
    }


    public static boolean isValid(String s) {
        //字符串长度为单数必不能匹配
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        //利用map集合来存储能够匹配的括号
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            //前面是key 后面是value
            //key-->value
            //要保证左括号和右括号匹配 故要写成 ）（
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        //创建一个栈
        Deque<Character> stack = new LinkedList<Character>();
        //对s中的字符进行循环判断
        for (int i = 0; i < n; i++) {
            //依此获取s中的每一个字符
            char ch = s.charAt(i);
            //如果匹配的字符是右括号 则进行判断
            //如果右括号开头则一定匹配失败
            //此时栈内为空故一定返回false
            if (map.containsKey(ch)) {
                //当栈为空时匹配失败
                //当栈顶（栈里的均为左括号）的括号元素与map里的值（左括号）不匹配时 则匹配失败
                //当出现([)]时
                //栈顶为[
                //而此时扫描到的括号为)
                //此时[！=(
                //匹配失败
                if (stack.isEmpty() || stack.peek() != map.get(ch)) {
                    return false;
                }
                //将栈顶元素移出 后进先出
                stack.pop();
            } else {
                //如果是左括号则入栈
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}