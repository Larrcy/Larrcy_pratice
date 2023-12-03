package day03.LeetCode168;

public class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber != 0) {
            columnNumber--;
            //转化字符串
            sb.append((char) (columnNumber % 26 + 'A'));
            //大于26则进入下一次循环
            columnNumber /= 26;
        }
        //拼接后进行反转
        return sb.reverse().toString();
    }
}

