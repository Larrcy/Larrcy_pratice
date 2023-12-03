package Offer1.S3;

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        //排除三种情况。  空串，e前没有数字，只有.
        String regex = "\\s*|([+-]?\\.?[e|E][\\s\\S]*)|([+-]?\\.)";
        if (s.matches(regex)) return false;
        regex = "(([+-])?\\d*\\.?\\d*)([E|e][+-]?\\d+)?";
        //对不是特殊情况的字符串，进行正则匹配
        return s.matches(regex);

    }
}
