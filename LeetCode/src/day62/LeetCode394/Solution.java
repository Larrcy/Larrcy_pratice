package day62.LeetCode394;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class Solution {
    public static String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ']')
                // 把所有的字符push进去，除了]
                stack.push(c);

            else {
                //step 1: 取出[] 内的字符串
                StringBuilder sb = new StringBuilder();
                //isLetter判断是否为字母
                while (!stack.isEmpty() && Character.isLetter(stack.peek()))
                //向左插入
                {
                    sb.insert(0, stack.pop());
                }
                String sub = sb.toString(); //[ ]内的字符串
                stack.pop(); // 去除[


                //step 2: 获取倍数数字

                sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                int count = Integer.parseInt(sb.toString()); //倍数


                //step 3: 根据倍数把字母再push回去

                while (count > 0) {
                    for (char ch : sub.toCharArray())
                        stack.push(ch);
                    count--;
                }
            }
        }

        //把栈里面所有的字母取出来
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.insert(0, stack.pop());

        return res.toString();
    }
}
