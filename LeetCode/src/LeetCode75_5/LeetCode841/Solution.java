package LeetCode75_5.LeetCode841;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //深搜
    private void dfs(int key, List<List<Integer>>  rooms, List<Boolean> visited) {

        if (visited.get(key)) {
            return;//当前访问节点为true，说明节点已访问 此时终止本层递归
        }
        //若不是true则将其赋值为true，将其作为本层递归所处理的节点
        visited.set(key, true);
        for (int k : rooms.get(key)) {
            // 深度优先搜索遍历
            dfs(k, rooms, visited);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        List<Boolean> visited = new ArrayList<Boolean>(){{
            for(int i = 0 ; i < rooms.size(); i++){
                add(false);
            }
        }};
        dfs(0, rooms, visited);
        //检查是否都访问到了
        for (boolean flag : visited) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
