package day77.LeetCode2416;

/**
 * 前缀树
 */
public class Solution {
    //创建前缀树
    class Node {
        Node[] son = new Node[26];
        int score;
    }
    public int[] sumPrefixScores(String[] words) {
        //前缀树模板
        Node root = new Node();
        for (String word : words) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                c -= 'a';
                if (cur.son[c] == null) cur.son[c] = new Node();
                cur = cur.son[c];
                ++cur.score; // 更新所有前缀的分数
            }
        }
        //创建数组收集结果
        int n = words.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            Node cur = root;
            for (char c : words[i].toCharArray()) {
                cur = cur.son[c - 'a'];
                ans[i] += cur.score; // 累加分数，即可得到答案
            }
        }
        return ans;
    }
}


