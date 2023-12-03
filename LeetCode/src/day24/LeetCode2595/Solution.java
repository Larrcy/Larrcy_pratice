package day24.LeetCode2595;

public class Solution {
    public static void main(String[] args) {
        evenOddBit(2);
    }
    public static int[] evenOddBit(int n) {
        int[]res =new int[2];
        StringBuilder count = new StringBuilder(Integer.toBinaryString(n));
         count = count.reverse();
        for (int i = count.length()-1; i >=0; i--) {
            if(count.charAt(i)=='1'&&i%2==0){
                res[0]++;
            }
            if(count.charAt(i)=='1'&&i%2!=0){
                res[1]++;
            }
        }
        return res;
    }
}
