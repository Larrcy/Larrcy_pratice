package HJ.JK001;

import java.util.*;

public class Solution1 {

    private static Queue<Integer> queue = new ArrayDeque<>();
    private static Queue<Node> nodes = new ArrayDeque<>();

    public static Node build() {  // 构建二叉树
        Node root = new Node(queue.poll());
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node top = nodes.poll();

            if (!queue.isEmpty()) {
                Node left = new Node(queue.poll());
                top.left = left;
                nodes.add(left);
            } else {
                break;
            }

            if (!queue.isEmpty()) {
                Node right = new Node(queue.poll());
                top.right = right;
                nodes.add(right);
            } else {
                break;
            }
        }
        return root;
    }


    public static Node remove(Node root) { // 递归删除叶子节点
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = remove(root.left);
        root.right = remove(root.right);
        return root;
    }

    public static void postTravel(Node root, List<String> p) { // 递归后序遍历
        if (root == null) {
            return;
        }
        postTravel(root.left, p);
        postTravel(root.right, p);
        p.add(String.valueOf(root.val));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        for (String s : str) {
            queue.add(Integer.parseInt(s));
        }
        Node root = build(); // 构建二叉树
        remove(root);  // 递归删除叶子节点
        List<String> res = new ArrayList<>();
        postTravel(root, res);  // 递归后序遍历
        System.out.print(String.join(" ", res));
    }
    static class Node {  // 构造二叉树数据结构
        private int val;
        private Node left;
        private Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
