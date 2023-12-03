package day03.LeetCode141;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

    //哈希表法
    public boolean hasCycle(ListNode head) {
        //创建一个哈希表
        //哈希表中每个数只会出现一次
        Set<ListNode> seen =new HashSet<>();
        while (head!=null){
            //seen.add(head)表示将head添加到哈希表中且判断哈希表中是否存在该值
            //若存在则返回false
            //不存在返回true
            if(!seen.add(head)){
            //存在重复节点 则链表有环
                return true;
            }
            //遍历每一个节点
            head=head.next;

        }

        //若链表为空 则一定没有环
        //若循环结束没有重复节点 则无环
        return false;

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

