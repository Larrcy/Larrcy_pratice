package day41.LeetCode38;

public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        //通过S(N-1)来求S(N)
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;
            while (pos < str.length()) {
                //统计连续的相同字符
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }

        return str;
    }

}
