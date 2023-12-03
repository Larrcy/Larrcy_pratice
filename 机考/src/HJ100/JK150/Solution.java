package HJ100.JK150;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            Arrays.sort(nums);
            nums[0]++;
        }
        Arrays.sort(nums);
        System.out.println(nums[0]);
    }
}
