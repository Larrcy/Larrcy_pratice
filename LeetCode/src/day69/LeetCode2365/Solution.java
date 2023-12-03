package day69.LeetCode2365;

import java.util.HashMap;
import java.util.List;

/**
 给你一个下标从 0 开始的正整数数组 tasks ，表示需要 按顺序 完成的任务，其中 tasks[i] 表示第 i 件任务的 类型 。

 同时给你一个正整数 space ，表示一个任务完成 后 ，另一个 相同 类型任务完成前需要间隔的 最少 天数。

 在所有任务完成前的每一天，你都必须进行以下两种操作中的一种：

 完成 tasks 中的下一个任务
 休息一天
 请你返回完成所有任务所需的 最少 天数。


 */
public class Solution {

    public long taskSchedulerII(int[] tasks, int space) {
        /*
        贪心+HashMap:
        注意:任务要按顺序完成
        HashMap存储下一次能做任务key的最早时间是第几天
        例如第一天做了任务1，那么要相隔3天，下一个能做任务1的最短时间就是第5天
        维护一个当前的天数cur，遍历当前的任务列表
        1.当cur能完成时task[i]时(map中存在该天数或者cur>=map[task[i]]) 当天完成该任务 cur++ 并更新map的天数
        2.当cur不能完成时task[i]时(cur<map[task[i]]) 此时只能等到map[task[i]]那天，直接cur=map[task[i]]然后完成，cur++
            并更新map对应的天数
        当遍历完最后一个时，返回cur-1就是答案
         */
        long cur = 1;
        HashMap<Integer, Long> map = new HashMap<>();
        // 当天任务类型
        for (int k : tasks) {
            // 当前日期不满足，跳到满足的那一天去做
            if (map.containsKey(k) && cur < map.get(k)) {
                cur = map.get(k);
            }
            map.put(k, cur + space + 1);    // 做了任务k，下一次最早在cur+space+1才能做
            cur++;  // 走到下一天
        }
        return cur - 1; // 因为做完最后一个跳多了一天，因此需要-1
    }

    public static void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
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


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void SelectSort(int[] nums) {
        //最后一位不用判断 故循环到 nums.length-1
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    //将后面遍历到的最小值赋值给min
                    min = nums[j];
                    //同时记录最小值的索引
                    minIndex = j;
                }
            }
            //若当前最小值的索引不是我们所假设的索引
            if (minIndex != i) {

                //则将假设的索引元素与我们所找到的最小元素进行互换
                nums[minIndex] = nums[i];
                nums[i] = min;

            }
        }

    }


}




