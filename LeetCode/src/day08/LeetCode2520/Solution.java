package day08.LeetCode2520;

public class Solution {
    public static void main(String[] args) {

    }

    public static int countDigits(int num) {
        int count =0;
        int temp =num;
        while (num!=0) {
            int val = num % 10;
            num = num / 10;
            if(temp%val==0){
                count++;

            }

        }
        return count;
    }
}
