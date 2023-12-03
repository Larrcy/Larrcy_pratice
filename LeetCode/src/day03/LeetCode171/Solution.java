package day03.LeetCode171;

public class Solution {
    public int titleToNumber(String columnTitle) {
        //获取字符串长度
        int n = columnTitle.length();
        int ans = 0;
        for(int i = 0; i < n; i++){
            //从前往后
            //将每一个字符进行拆分相加
            ans = ans*26+(columnTitle.charAt(i)-'A'+1);
        }
        return ans;
    }
}
