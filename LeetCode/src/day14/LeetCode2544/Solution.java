package day14.LeetCode2544;

public class Solution {
    public static void main(String[] args) {

    }

    public int alternateDigitSum(int n) {
        int sum = 0;
        int i = 1;
        while (n != 0) {
            if (i % 2 != 0) {
                sum += n % 10;
            } else {
                sum -= n % 10;
            }
            n = n / 10;
            i++;
        }
        if(i%2==0){
        return sum;}
        else return -sum;
    }
}
