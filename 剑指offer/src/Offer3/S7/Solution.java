package Offer3.S7;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String reverseWords(String s) {
        //双端队列
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        Deque<String> d = new ArrayDeque<String>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                //将单词放到队列后将其长度归零
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                //不为空格则将字母添加进单词
                word.append(c);
            }
            left++;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

}

