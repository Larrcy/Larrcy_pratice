package day26.LeetCode395;

public class Solution {
    public int longestSubstring(String s, int k) {
        if(s.length() < k)
        {
            return 0;
        }
        //统计各个字符的数量
        int [] count = new int [26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)- 'a']++;
        }
        for(int i=0;i<s.length();i++){
            char ca = s.charAt(i);
            //判断条件 找到小于出现k次的字符串
            if(count[ca - 'a'] < k)
            {
                int res = 0;
                //将字符串按照ca进行分割 分割后每个子串t都不包含ca
                //继续将字串中的小于k次出现的元素删除 直到不能继续删除为止
                //最后所得的子串一定是满足条件的
                for (String t : s.split(String.valueOf(ca))) {
                    res = Math.max(res, longestSubstring(t, k));
                }
                return res;
            }
        }
        //原字符串里面没有小于k的字符串 直接返回字符串长度
        return s.length();
    }
}
