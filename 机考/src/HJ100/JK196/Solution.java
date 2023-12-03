package HJ100.JK196;

import java.util.Scanner;
//分奖金
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i]=nums[i];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = (nums[j]-nums[i]) * (j - i);
                    break;
                }
            }

        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
