package 模板.线段树.LeetCode732;


/**
 * 对于表示为「区间最值」且对区间进行「加减」的更新操作的情况，我们在更新节点值的时候『不需要✖️左右孩子区间叶子节点的数量 (注意是叶子节点的数量)』；我们在下推懒惰标记的时候『需要累加』！！ 如题目 我的日程安排表 I、我的日程安排表 III
 */
public class Solution {
    //模板主要区别在pushDown
    public void MyCalendarThree() {

    }

    public int book(int start, int end) {
        // 只用到了 update
        update(root, 0, N, start, end - 1, 1);
        // 最大值即为根节点的值
        return root.val;
    }
    // *************** 下面是模版 ***************
    class Node {
        // 左右孩子节点
        Node left, right;
        // 当前节点值，以及懒惰标记的值
        int val, add;
    }
    private int N = (int) 1e9;
    private Node root = new Node();
    public void update(Node node, int start, int end, int l, int r, int val) {
        if (l <= start && end <= r) {
            node.val += val;
            node.add += val;
            return ;
        }
        pushDown(node);
        int mid = (start + end) >> 1;
        if (l <= mid) update(node.left, start, mid, l, r, val);
        if (r > mid) update(node.right, mid + 1, end, l, r, val);
        pushUp(node);
    }
    public int query(Node node, int start, int end, int l, int r) {
        if (l <= start && end <= r) return node.val;
        pushDown(node);
        int mid = (start + end) >> 1, ans = 0;
        if (l <= mid) ans = query(node.left, start, mid, l, r);
        if (r > mid) ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
        return ans;
    }
    private void pushUp(Node node) {
        // 每个节点存的是当前区间的最大值
        node.val = Math.max(node.left.val, node.right.val);
    }
    private void pushDown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return ;
        node.left.val += node.add;
        node.right.val += node.add;
        node.left.add += node.add;
        node.right.add += node.add;
        node.add = 0;
    }
}
