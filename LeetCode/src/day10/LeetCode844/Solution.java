package day10.LeetCode844;

public class Solution {
    public static void main(String[] args) {

    }
    //一个字符是否会被删掉，只取决于该字符后面的退格符，而与该字符前面的退格符无关。
    //逆序地遍历字符串，可以确定当前字符是否会被删掉。
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                //逆序遍历 查找字符#
                if (S.charAt(i) == '#') {
                    //skip即为#的个数
                    //skip为0表示当前字符不需要删除
                    //skip不为0则当前字符需要进行删除
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    //跳过带有#的前一个字符
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            //删除完成后进行判断
            //如果 index = 0 位置上为 '#'，则 i, j 会为 -1
            // 而 index = -1 的情况应当处理。
            if (i >= 0 && j >= 0) {
                //判断删除完成后的字符是否相等
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            }
            // (i >= 0 && j >= 0) 为 false 情况为
            // 1. i < 0 && j >= 0
            // 2. j < 0 && i >= 0
            // 3. i < 0 && j < 0
            // 其中，第 3 种情况为符合题意情况，因为这种情况下 s 和 t 都是 index = 0 的位置为 '#' 而这种情况下
            // 退格空字符即为空字符，也符合题意，应当返回 True。
            // 但是，情况 1 和 2 不符合题意，因为 s 和 t 其中一个是在 index >= 0 处找到了待比较字符，另一个没有找到
            // 这种情况显然不符合题意，应当返回 False，下式便处理这种情况。
            else if (i >= 0 || j >= 0) {
                    return false;
                }

            i--;
            j--;
        }
        return true;
    }
}
