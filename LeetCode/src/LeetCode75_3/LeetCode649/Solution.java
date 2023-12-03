package LeetCode75_3.LeetCode649;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public String predictPartyVictory(String senate) {
        //定义两个队列存储R D的数组下标
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        char c;
        for (int i = 0; i < n; i++) {
            c = senate.charAt(i);
            if (c == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        //当两个队列都不为空时将判断后的元素插入到队列当中，并将之前判断的元素移除队列
        //进行下一轮的判断
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.remove();
            int d = dire.remove();
            if (r < d) {
                radiant.offer(r + n);
            } else {
                dire.offer(d + n);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
