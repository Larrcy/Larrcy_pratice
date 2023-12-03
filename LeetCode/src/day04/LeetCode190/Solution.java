package day04.LeetCode190;

public class Solution {
    public static void main(String[] args) {

        int n = 000001;
        System.out.println(reverseBits(n));
    }

    public static int reverseBits(int n) {
        String s ="";
        //反转二进制数
        while (n != 0) {
           s=s+n%2;
            n = n / 2;
        }
        int result =0;
        int j =0;
        for (int i = s.length()-1; i >=0; i--) {

            result = (int) (result+Integer.parseInt(String.valueOf(s.charAt(i)))*Math.pow(2,j));
            ++j;
        }


        return result;

    }
}
