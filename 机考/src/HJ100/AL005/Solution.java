package HJ100.AL005;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        String[] s = str.split(",");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int left = 0;
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (i >= n-1) {
                max = Math.max(count, max);
                count -= nums[left];
                left++;
            }
        }
        System.out.println(max);
    }
}
