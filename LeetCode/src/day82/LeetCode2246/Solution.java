package day82.LeetCode2246;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一棵 树（即一个连通、无向、无环图），根节点是节点 0 ，这棵树由编号从 0 到 n - 1 的 n 个节点组成。用下标从 0 开始、长度为 n 的数组 parent 来表示这棵树，其中 parent[i] 是节点 i 的父节点，由于节点 0 是根节点，所以 parent[0] == -1 。
 * <p>
 * 另给你一个字符串 s ，长度也是 n ，其中 s[i] 表示分配给节点 i 的字符。
 * 请你找出路径上任意一对相邻节点都没有分配到相同字符的 最长路径 ，并返回该路径的长度。
 */
public class Solution {
    List<Integer>[] g;
    String s;
    int ans;
    int n;
    private char[] chs;                // 每个节点对应的字符
    //树形dp
    //相当于求路径最大和路径第二大的和
    public int longestPath(int[] parent, String s) {
        this.s = s;
        //建树 类似于建图
        n = parent.length;
        chs = s.toCharArray();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[parent[i]].add(i);
        }
        //从0节点开始遍历
        dfs(0);
        return ans;
    }

    int dfs(int curr) {
        // 如果越过叶子节点，路径为 0
        if (curr >= n) return 0;
        int max1 = 0; // max1 curr 的子树中，与 curr 字符不同且合法路径最长的长度
        int max2 = 0; // max2 curr 的子树中，与 curr 字符不同且合法路径第二长的长度

        // 求最长子树的长度
        for (int child : g[curr]) {
            int childLen = dfs(child);
            if (childLen > max1 && chs[curr] != chs[child]) {
                max2 = max1;
                max1 = childLen;
            } else if (childLen > max2 && chs[curr] != chs[child]) {
                max2 = childLen;
            }
        }
        //后序位置收集结果
        // 最终的结果可能是 curr 及其两棵最长的子树所形成的
        ans = Math.max(ans, max1 + max2 + 1);
        // 返回最长的路径
        return max1 + 1;
    }
}
