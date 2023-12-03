package Char01.S5.LeetCode76;

public class Solution {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        //特殊情况
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        //维护两个数组，记录已有字符串指定字符的出现次数，和目标字符串指定字符的出现次数
        //ASCII表总长128
        int[] need = new int[128];
        int[] have = new int[128];

        //记录t的字符出现的次数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        //已有字符串中目标字符串指定字符的出现总频次以及最小覆盖子串在原字符串中的起始位置
        //依次表示 左指针 右指针 最小长度值 t字符在s中出现的次数 最短字符的起始位置
        int left = 0, right = 0, min = s.length() + 1, count = 0, start = 0;
        //右指针向右滑动
        while (right < s.length()) {
            //获取右指针所指的字符
            char r = s.charAt(right);
            //若读取字符在t中没有则向右移动
            //指针一直向右移动直到找到t中所含的字符
            if (need[r] == 0) {
                right++;
                continue;
            }
            //当已有字符串目标字符出现的次数小于目标字符串字符的出现次数时，count才会+1
            if (have[r] < need[r]) {
                //count相当于统计s中含有的t的字符
                count++;
            }
            //已有字符串中目标字符出现的次数+1
            have[r]++;
            //移动右指针
            right++;
            //当s中含有t的全部字符时（count 与t的长度相等）
            while (count == t.length()) {
                //此时有字符长度的最小值
                if (right - left < min) {
                    min = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                //如果左边即将要去掉的字符不被目标字符串需要，那么不需要多余判断，直接可以移动左指针
                if (need[l] == 0) {
                    left++;
                    continue;
                }
                //如果左边即将要去掉的字符被目标字符串需要，且出现的频次正好等于指定频次，那么如果去掉了这个字符，
                //就不满足覆盖子串的条件，此时要破坏循环条件跳出循环，即控制目标字符串指定字符的出现总频次(count）-1
                if (have[l] == need[l]) {
                    count--;
                }
                //已有字符串中目标字符出现的次数-1
                have[l]--;
                //移动左指针
                left++;
            }
        }
        //如果最小长度还为初始值，说明没有符合条件的子串
        if (min == s.length() + 1) {
            return "";
        }
        //返回的为以记录的起始位置为起点，记录的最短长度为距离的指定字符串中截取的子串
        return s.substring(start, start + min);

    }
}

