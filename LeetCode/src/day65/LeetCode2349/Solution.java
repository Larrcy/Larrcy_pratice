package day65.LeetCode2349;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 设计一个数字容器系统，可以实现以下功能：
 *
 * 在系统中给定下标处 插入 或者 替换 一个数字。
 * 返回 系统中给定数字的最小下标。
 * 请你实现一个 NumberContainers 类：
 *
 * NumberContainers() 初始化数字容器系统。
 * void change(int index, int number) 在下标 index 处填入 number 。如果该下标 index 处已经有数字了，那么用 number 替换该数字。
 * int find(int number) 返回给定数字 number 在系统中的最小下标。如果系统中没有 number ，那么返回 -1 。
 */
class Solution {
    Map<Integer, Integer> m = new HashMap<>();
    Map<Integer, TreeSet<Integer>> ms = new HashMap<>();

    public void change(int index, int number) {
        //用var来接收m.get(index)判断是否为空
        int oldNumber = m.get(index);
        //若又添加一个同样的number则将旧的index移除添加新的index
        if (oldNumber != 0) ms.get(oldNumber).remove(index); // 移除旧数据
        m.put(index, number);
        //computeIfAbsent()
        //1、首先会判断map中是否有对应的Key；
        //2.1、如果没有对应的Key，则会创建一个满足Value类型的数据结构放到Value的位置中；
        //2.2、如果有对应的Key，则会操作该Key对应的Value.
        ms.computeIfAbsent(number, k -> new TreeSet<>()).add(index); // 添加新数据
    }

    public int find(int number) {
        TreeSet<Integer> s = ms.get(number);
        return s == null || s.isEmpty() ? -1 : s.first();
    }

}