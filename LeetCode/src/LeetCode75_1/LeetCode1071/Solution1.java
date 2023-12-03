package LeetCode75_1.LeetCode1071;

public class Solution1 {
    //枚举
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        // 从长度大的开始枚举
        for (int i = Math.min(len1, len2); i >= 1; --i) {
            //若找到长度的公约数则进行字符串截取
            if (len1 % i == 0 && len2 % i == 0) {
                String X = str1.substring(0, i);
                if (check(X, str1) && check(X, str2)) {
                    return X;
                }
            }
        }
        return "";
    }
//判断拼接若干次是否能与str1 str2相等
    public boolean check(String t, String s) {
        //lenx 为拼接次数
        int lenx = s.length() / t.length();
        StringBuffer ans = new StringBuffer();
        for (int i = 1; i <= lenx; ++i) {
            ans.append(t);
        }
        return ans.toString().equals(s);
    }

    }

