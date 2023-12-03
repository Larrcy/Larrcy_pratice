package LeetCode75_4.LeetCode1161;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer>list =new ArrayList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int len = que.size();
            int num =0;
            for (int i = 0; i < len; i++) {
                TreeNode tmpNode = que.poll();
                num+=tmpNode.val;
                if (tmpNode.left!=null)que.offer(tmpNode.left);
                if (tmpNode.right!=null)que.offer(tmpNode.right);
            }
            list.add(num);
        }
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if(collect.get(collect.size()-1)==list.get(i)){
                return i+1;
            }
        }
        return -1;
    }


        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }


    }

