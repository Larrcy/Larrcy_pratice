package LeetCode.Week349;

public class Solution2 {
    //执行一次操作更改字典序
    //若把a替换成z会导致字典序变大 故子串里不能包含a
    //若s全为a则必须执行一次操作 故替换最后的a即可
    public String smallestString(String s) {
        //将字符串放入数组
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            //找到最左端的不为a的元素
            if (chars[i] != 'a') {
                //从该元素位置往后遍历直至遇到a或到数组末尾
                for (; i < n && chars[i] != 'a'; i++) {
                    chars[i]--;
                    return new String(chars);
                }

            }
        }
        //特殊情况
        chars[n - 1] = 'z';
        return new String(chars);

    }
}
