package day04.LeetCode11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int[] height ={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));

    }
    public static int maxArea(int[] height) {

        Stack<Integer> stack =new Stack<>();
        for (int i = 0; i < height.length; i++) {
            for(int j=1;j<height.length;j++){
                stack.push(((j-i)*(Math.min(height[i],height[j]))));
            }
        }
       return Collections.max(stack);
    }
}
