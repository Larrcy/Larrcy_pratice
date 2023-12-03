package HJ100.JK034;

import sun.reflect.generics.visitor.Reifier;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    //能力组队
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int pow = sc.nextInt();
        System.out.println(func(nums, pow));
    }

    public static int func(int[] nums, int pow) {
        Arrays.sort(nums);
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= pow) {
                right = i;
                break;
            }
        }
        int res = nums.length - right;
        int left = 0;
        while (left < right) {
            while (nums[left] + nums[right] < res) {
                left++;
            }
            if (nums[left] + nums[right] >= res) {
                res++;
                left++;
                right--;
            }
        }
        return res;
    }
}
