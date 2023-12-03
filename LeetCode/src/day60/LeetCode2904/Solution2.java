package day60.LeetCode2904;

public class Solution2 {
    /*
     * 法二 滑动窗口
     * 本题要求答案恰好有k个 故可以利用滑动窗口
     * 若窗口内的1超过k个或者窗口端点为0则移动指针
     */
    public String shortestBeautifulSubstring(String s, int k) {
        if (s.replaceAll("0", "").length() < k) {
            return "";
        }
        char[] chars = s.toCharArray();
        String ans = s;
        //count 记录1的个数
        int count = 0;
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            //右指针向右滑动记录1的个数
            if (chars[i] == '1') {
                count++;
            }
            //若1的个数大于k
            //则左值针右移且减少1的个数
            //若左值针所指位置为0
            //则左值针也要移动
            //直到第一个不为0的位置
            while (count > k || chars[left] == '0') {
                if (chars[left] == '1') {
                    count--;
                }
                left++;
            }
            //当count==k时开始收集结果
            if (count == k) {
                String t = s.substring(left, i + 1);
                if (t.length() < ans.length() || t.length() == ans.length() && t.compareTo(ans) < 0) {
                    ans = t;
                }
            }
        }
        return ans;
    }
}
