package day40.LeetCode200;

public class Solution2 {
    class UnionFind {
        //parent[i]=k 表示i的父亲是k
        private int[] parent;
        //size[i]=k 若i是代表节点 size[i]才有意义否则无意义
        //表示i所在集合的大小
        private int[] size;
        //记录列数和行数
        private int col;
        private int row;
        private int[] help;
        //一共有多少集合
        private int sets;

        public UnionFind(char[][] grid) {
            col = grid[0].length;
            sets = 0;
            row = grid.length;
            int n = row * col;
            parent = new int[n];
            size = new int[n];
            help = new int[n];

            //刚开始所有集合的父亲节点是自己
            //集合的大小是1
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (grid[r][c] == '1') {
                        int i = index(r, c);
                        parent[i] = i;
                        size[i] = 1;
                        sets++;

                    }
                }
            }
        }

        //将r行c列的下标转换成1维下标
        private int index(int r, int c) {
            return r * col + c;
        }


        //从下往上进行返回 直到到达最顶端
        //help是用来保存遍历过程中的节点用于弹出时让这些节点的父亲都指向最顶端节点
        //然后从最顶端依次将其父亲节点修改成最顶端节点的值
        private int find(int i) {
            int h = 0;
            while (i != parent[i]) {
                help[h++] = i;
                i = parent[i];
            }
            //最后h会指向空 故h要后退1位
            //此时将help存的节点都指向父节点
            for (h--; h >= 0; h--) {
                parent[help[h]] = i;
            }
            return i;

        }

        //合并集合
        //把小的合并到大的上
        public void union(int r1, int c1, int r2, int c2) {
            int i1 = index(r1, c1);
            int i2 = index(r2, c2);
            int f1 = find(i1);
            int f2 = find(i2);
            if (f1 != f2) {
                if (size[f1] >= size[f2]) {
                    size[f1] += size[f2];
                    parent[f2] = f1;
                } else {
                    size[f2] += size[f1];
                    parent[f1] = f2;
                }
                sets--;
            }

        }
    }
}
