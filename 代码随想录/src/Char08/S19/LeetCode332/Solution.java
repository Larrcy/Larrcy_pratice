package Char08.S19.LeetCode332;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static LinkedList<String> path = new LinkedList<>();
    public static List<String> res = new ArrayList<>();

    public static List<String> findItinerary(List<List<String>> tickets) {
        //对集合里的目标地按字典序排序
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        path.add("JFK");
        boolean[] used = new boolean[tickets.size()];
        backtracking(tickets, used);
        return res;
    }

    public static boolean backtracking(List<List<String>> tickets, boolean[] used) {
        //终止条件
        // 遇到的机场个数，如果达到了航班数量+1
        // 那么我们就找到了一个行程，把所有航班串在一起了。
        if (path.size() == tickets.size() + 1) {
            res = new LinkedList<>(path);
            return true;
        }
        //对集合里面的每一个集合进行遍历
        for (int i = 0; i < tickets.size(); i++) {
            //若遍历到的集合未重复出现 且其起点与集合中最后一个终点相同
            //则添加进集合并进行回溯
            if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
                path.add(tickets.get(i).get(1));
                used[i] = true;

                //进行递归回溯
                //将true结果返回到起始位置
                if (backtracking(tickets, used)) {
                    return true;
                }
                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }
}
