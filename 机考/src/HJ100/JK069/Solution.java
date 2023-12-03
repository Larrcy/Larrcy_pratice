package HJ100.JK069;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        int[]res =new int[n];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j]>nums[i]){
                    res[i]=j;
                    break;
                }
                if(j==nums.length-1){
                    res[i]=0;
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            if(i== res.length-1){
                System.out.println(res[i]);
            }
          else   System.out.print(res[i]+" ");
        }
    }
}
