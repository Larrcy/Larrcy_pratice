package 模板.前缀树.Trie;

public class Solution {
    //默认以""为头结点
    class Trie {
        int p;
        Trie[] next = new Trie[26];
        public Trie() {
        }

        public Trie(int p) {
            this.p = p;
        }
        //将s的每个字符添加进字典树
        private void addNode(String s) {
            if (s.equals("")) {
                this.p++;
                return;
            }
            Trie pre = this;
            this.p++;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (pre.next[c - 'a'] == null) {
                    pre.next[c - 'a'] = new Trie(1);
                } else {
                    pre.next[c - 'a'].p++;
                }
                pre = pre.next[c - 'a'];
            }

        }
        //累加s每个字符的分数
        private int count(String s){
            int sum = 0;
            Trie pre = this;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                pre = pre.next[c - 'a'];
                sum += pre.p;
            }
            return sum;
        }

    }
}
