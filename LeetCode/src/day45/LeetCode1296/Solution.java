package day45.LeetCode1296;


import java.util.*;

public class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) queue.offer(num);
        while (!queue.isEmpty()){
            int num = queue.poll();
            for (int i = 0; i < k - 1; i++){
                if (!queue.contains(num + 1)) return false;
                queue.remove(num+1);
                num++;
            }
        }
        return true;
    }

}
