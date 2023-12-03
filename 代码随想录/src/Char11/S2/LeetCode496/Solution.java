package Char11.S2.LeetCode496;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= stack.peek()) {
                stack.push(nums2[i]);
            } else {
                while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                    if (map.containsKey(stack.peek())) {
                        res[map.get(stack.peek())] = nums2[i];
                    }
                    stack.pop();

                }
                stack.push(nums2[i]);
            }
        }
        return res;
    }
}
