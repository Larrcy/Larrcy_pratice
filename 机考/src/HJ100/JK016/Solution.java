package HJ100.JK016;

import java.util.Scanner;

//喊7
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int count = 0;
        for (int i = 0; i < split.length; i++) {
            count += Integer.parseInt(split[i]);
        }
        int n = split.length;
        int[] nums = new int[n];
        int k = 200;
        for (int i = 1; i <= k; i++) {
            if (i == 7 || i % 10 == 7 || (i > 10 && i / 10 % 7 == 0) || (i > 10 && i / 10 == 7) || (i > 10 && i % 7 == 0)) {
                nums[(i - 1) % n]++;
                count--;
                if (count == 0) {
                    break;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
