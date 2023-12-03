package HJ100.JK055;

import java.util.Scanner;
//gpu调度
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(func(task, nums));
    }

    public static int func(int task, int[] nums) {
        int count = 0;
        int remain = 0;
        for (int i = 0; i < nums.length; i++) {
            if (remain + nums[i] > task) {
                remain = nums[i] + remain - task;
            } else {
                remain = 0;
                count++;
            }

            while (remain > 0) {
                remain -= task;
                count++;
            }
        }
        return count;

    }
}
