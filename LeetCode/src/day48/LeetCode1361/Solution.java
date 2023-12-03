package day48.LeetCode1361;

import java.util.ArrayList;
import java.util.*;

public class Solution {
    int n;
    int[] leftChild;
    int[] rightChild;
    int visitCount = 0;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        this.n = n;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        int edges = 0;
        int[] indegrees = new int[n];
        for (int i = 0; i < n; i++) {
            int left = leftChild[i], right = rightChild[i];
            if (left >= 0) {
                edges++;
                indegrees[left]++;
            }
            if (right >= 0) {
                edges++;
                indegrees[right]++;
            }
        }
        if (edges != n - 1) {
            return false;
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                if (root < 0) {
                    root = i;
                } else {
                    return false;
                }
            } else if (indegrees[i] > 1) {
                return false;
            }
        }
        if (root < 0) {
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            int left = leftChild[i], right = rightChild[i];
            if (left >= 0) {
                uf.union(i, left);
            }
            if (right >= 0) {
                uf.union(i, right);
            }
        }
        return uf.getCount() == 1;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        rank = new int[n];
        count = n;
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
            count--;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public int getCount() {
        return count;
    }
}


