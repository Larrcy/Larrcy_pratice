package HJ100.JK004;

import java.util.Scanner;

//猴子爬山
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 1;

        for (int i = 3; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i - 3];
        }
        System.out.println(nums[n]);
    }

}
