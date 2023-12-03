package HJ.JK115;

import java.util.Stack;

//压缩报文还原
public class Solution {
    public static String decompress(String compressed) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int num = 0;

        for (char c : compressed.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(currentStr);
                num = 0;
                currentStr = new StringBuilder();
            } else if (c == ']') {
                int repeatTimes = numStack.pop();
                StringBuilder prevStr = strStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    prevStr.append(currentStr);
                }
                currentStr = prevStr;
            } else {
                currentStr.append(c);
            }
        }

        return currentStr.toString();
    }

    public static void main(String[] args) {
        String input1 = "3[k]2[mn]";
        String input2 = "3[m2[c]]";

        String output1 = decompress(input1);
        String output2 = decompress(input2);

        System.out.println(output1); // 输出: kkkmnmn
        System.out.println(output2); // 输出: mccmccmcc
    }
}
