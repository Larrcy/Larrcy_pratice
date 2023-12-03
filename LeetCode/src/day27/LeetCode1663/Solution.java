package day27.LeetCode1663;

public class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {//从后往前遍历
            //这里k代表的是前i个元素的字符数值之和，我觉得根本不需要那种繁杂的公式推导
            //因为很简单的道理只要后面的字符尽可能大就好，当然无法尽可能大，限制就是前面的字符最小只能为a也就是1大小
            //所以Math.min的右边参数的意思是这个位置的元素数值最大不能超过前面都是a也就是1的大小，否则就无法达到n的长度了
            int res = Math.min(26, (k - i + 1));
            sb.append((char)('a' + res - 1));
            k -= res;
        }
        return sb.reverse().toString();
    }


}
