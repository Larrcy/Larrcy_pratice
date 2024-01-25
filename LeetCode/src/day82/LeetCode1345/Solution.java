package day82.LeetCode1345;

import java.util.*;

/**
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * <p>
 * 每一步，你可以从下标 i 跳到下标 i + 1 、i - 1 或者 j ：
 * <p>
 * i + 1 需满足：i + 1 < arr.length
 * i - 1 需满足：i - 1 >= 0
 * j 需满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * <p>
 * 注意：任何时候你都不能跳到数组外面。
 */
public class Solution {
    //将给定的数组整理成无向图
    //把数组中相邻的元素或者元素值相同的元素进行相连
    //从下标0位置开始搜索直至数组最后一个位置
    //利用bfs进行遍历 计算遍历层数即可

    /**
     * <img width="500" height="400" src="https://pic.leetcode-cn.com/1642848377-fiRFrc-file_1642848381648">
     */
    public int minJumps(int[] arr) {
        //建立无向图
        int n = arr.length;
        if (n == 1) return 0;
        // 存储某个值对应有哪些索引
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
                map.get(arr[i]).add(i);
            }
            map.get(arr[i]).add(i);
        }
        int res = 0;
        //BFS遍历框架
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int idx = queue.poll();
                if (idx == n - 1) return res;
                //3种选择 向前跳向后跳
                //跳到相同点
                if (map.containsKey(arr[idx])) {
                    for (Integer next : map.get(arr[idx])) {
                        if (!visited[next]) {
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }
                //剪枝 走完这段路径后删除该值避免走重复路
                map.remove(arr[idx]);

                if (idx + 1 <= n - 1 && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    queue.add(idx + 1);
                }
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    queue.add(idx - 1);
                }
            }
            res++;
        }
        return res;
    }
}
