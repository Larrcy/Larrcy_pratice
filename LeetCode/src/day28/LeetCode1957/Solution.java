package day28.LeetCode1957;

public class Solution {
    public String makeFancyString(String s) {
        StringBuilder res = new StringBuilder();
        if (s.length() <= 2) return s;
        res.append(s.charAt(0));
        int count = 1;//已经加入第一个字符了
        char k = s.charAt(0);//标记字符
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != k) { //不一样直接加入
                //重置count并记录k的值
                count = 1;
                k = s.charAt(i);
                res.append(s.charAt(i));
            } else if (count < 2){ //一样，count小于2则加入
                res.append(s.charAt(i));
                count++;
            }
        }
        return res.toString();
    }

}
